package com.spring.boot.demo.controller;


import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import cn.hutool.http.HttpUtil;

/**
 * 写作猫
 *
 * @author xuchonggao
 * @date 2020/01/14
 */
public class XieZuoMao {

    private static final OkHttpClient client;

    static {
        OkHttpClient.Builder cb = new OkHttpClient.Builder();
        cb.sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts());
        cb.hostnameVerifier(new TrustAllHostnameVerifier());
        cb.connectTimeout(60, TimeUnit.SECONDS);
        cb.readTimeout(60, TimeUnit.SECONDS);
        client = cb.build();
    }

    /**
     * 访问主页 获取JSession
     */
    private static String getJSession() throws IOException {
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/project/demoCheckDoc?pageIndex=1&pageSize=999&isSampleDocument=false")
                .method("GET", null)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.63")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie",
                        "Hm_lvt_099c1a390e23e6b73b081c48519f6e8e=1578985568; Hm_lpvt_099c1a390e23e6b73b081c48519f6e8e=1578985568")
                .build();
        try (Response response = client.newCall(request).execute()) {
            String jSession = null;
            if (response.isSuccessful()) {
                jSession = response.header("Set-Cookie");
            }
            if (StringUtils.isNotBlank(jSession)) {
                String regex = ";";
                if (jSession.contains(regex)) {
                    String[] split = jSession.split(regex);
                    for (String s : split) {
                        if (s.startsWith("JSESSIONID")) {
                            jSession = s;
                        }
                    }
                }
                //登录

            }
            System.out.println(jSession);
            return jSession;
        }

    }

    /**
     * 登录并获取session
     */
    public static Optional<String> loginCookie(String username, String password)
            throws IOException {
        String jSession = getJSession();
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType,
                "{\"login_by\":\"account\",\"account\":\"" + username + "\",\"pwd\":\"" + password
                        + "\"}");
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/login")
                .method("POST", body)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Origin", "https://xiezuocat.com")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.65")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", jSession)
                .build();
        try (Response response = client.newCall(request).execute();) {
            if (response.isSuccessful()) {
                List<String> headers = response.headers("Set-Cookie");
                if (CollectionUtils.isNotEmpty(headers)) {
                    StringBuilder sb = new StringBuilder();
                    headers.stream().map(s -> s.split(";")[0])
                            .forEach(s -> sb.append(s).append("; "));
                    sb.append(jSession).append("; ");
                    return Optional.of(sb.toString());
                }
            }
            return Optional.empty();
        }
    }

    /**
     * 防止cookie过期 带cookie请求某个接口
     */
    public static String keepSession(String cookie) throws IOException {
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/getUserProduct?productType=0&isSampleDocument=false")
                .method("GET", null)
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.63")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
            return StringUtils.EMPTY;
        }

    }

    /**
     * 检测错别字
     */
    public static String checkContent(String cookie, String aId, String content)
            throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject jb = new JSONObject();
        jb.put("content", "<p>" + content + "</p>");
        jb.put("contentText", content);
        jb.put("cursorPosition", 0);
        jb.put("docId", aId);

        RequestBody body = RequestBody.create(mediaType, jb.toJSONString());
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/checkContent")
                .method("POST", body)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Origin", "chrome-extension://giijkmholjmdmpojlmmoieghkilnhkhb")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.63")
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "*/*")
                .addHeader("Sec-Fetch-Site", "cross-site")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
            return StringUtils.EMPTY;
        }
    }

    public static String newEmptyDoc(String cookie, String projectId) throws IOException {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody
                .create(mediaType, "{\"projectId\":" + projectId + ",\"docName\":null}");
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/newEmptyDoc?isSampleDocument=false")
                .method("POST", body)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Origin", "https://xiezuocat.com")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.65")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            JSONObject bodyObj = JSONObject.parseObject(response.body().string());
            return bodyObj.getJSONObject("errMsg").getString("id");
        }
        return null;
    }

    public static void updateTitle(String cookie, String id, String title) throws IOException {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody
                .create(mediaType, "{\"docId\":" + id + ",\"title\":\"" + title + "\"}");
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/updateDocTitle?isSampleDocument=false")
                .method("POST", body)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Origin", "https://xiezuocat.com")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.65")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void updateContent(String cookie, String id, String content) throws IOException {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType,
                "{\"docId\":" + id + ",\"content\":\"<p>" + content + "</p>\",\"contentText\":\""
                        + content + "\",\"zenMode\":0}");
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/updateContent?isSampleDocument=false")
                .method("POST", body)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Origin", "https://xiezuocat.com")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.65")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static String getFirstProjectId(String cookie) throws IOException {
        Request request = new Request.Builder()
                .url("https://xiezuocat.com/html/myFirstProject?isSampleDocument=false")
                .method("GET", null)
                .addHeader("Host", "xiezuocat.com")
                .addHeader("Accept", "application/json, text/plain, */*; charset=utf-8")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36 Edg/79.0.309.65")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://xiezuocat.com/")
                .addHeader("Accept-Language",
                        "zh-Hans-CN,zh-CN;q=0.9,zh;q=0.8,en;q=0.7,en-GB;q=0.6,en-US;q=0.5")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        return JSONObject.parseObject(response.body().string()).getString("id");
    }


    public static class TrustAllHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;//trust All的写法就是在这里写的，直接无视hostName，直接返回true，表示信任所有主机
        }

    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }

    public static class TrustAllCerts implements X509TrustManager {

        //checkServerTrusted和checkClientTrusted 这两个方法好像是用于，server和client双向验证
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /**
     * 统计文章字数
     */
    public static int getMSWordsCount(String context) {
        int words_count = 0;
        //中文单词
        String cn_words = context.replaceAll("[^(\\u4e00-\\u9fa5，。《》？；’‘：“”【】、）（……￥！·)]", "");
        int cn_words_count = cn_words.length();
        //非中文单词
        String non_cn_words = context
                .replaceAll("[^(a-zA-Z0-9`\\-=\';.,/~!@#$%^&*()_+|}{\":><?\\[\\])]", " ");
        int non_cn_words_count = 0;
        String[] ss = non_cn_words.split(" ");
        for (String s : ss) {
            if (s.trim().length() != 0) {
                non_cn_words_count++;
            }
        }
        //中文和非中文单词合计
        words_count = cn_words_count + non_cn_words_count;
        return words_count;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String cookie = "traceid=a23dd46b177c40a8; JSESSIONID=06070193356CC7B50426C7F6483E27E1; _ga=GA1.2.1563591988.1579252819; _gid=GA1.2.41833161.1579252819; uid=5e1e94916e325742fbd89c35; sid=d39425fc710047bfa6404c56b216c7f4; Hm_lvt_099c1a390e23e6b73b081c48519f6e8e=1579251187,1579252638,1579252700,1579253135; Hm_lvt_6b70550338b3d4b9df0afd2fc87d282c=1579251187,1579252639,1579252701,1579253136; _gat_gtag_UA_136107152_2=1; Hm_lpvt_6b70550338b3d4b9df0afd2fc87d282c=1579253258; Hm_lpvt_099c1a390e23e6b73b081c48519f6e8e=1579253262";
        List<String> urls = IOUtils.readLines(new FileInputStream("/Users/weiyongjun/Desktop/aa"));
        String projectId = getFirstProjectId(cookie);
        for (String url : urls) {
            String[] split = url.split(" ");
            String docId = split[0];
            url = split[1];
            String resp = HttpUtil.get(url);
            JSONObject data = JSONObject.parseObject(resp).getJSONObject("data");

            String content = Jsoup.parse(data.getString("content")).text()
                    .replaceAll("\\s+", StringUtils.EMPTY);
            System.out.println("================== " + docId);
            String aId = newEmptyDoc(cookie, projectId);
            updateTitle(cookie, aId, docId);
            TimeUnit.SECONDS.sleep(2);
            updateContent(cookie, aId, content);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(checkContent(cookie, aId, content));
            TimeUnit.SECONDS.sleep(2);
        }

    }

}

