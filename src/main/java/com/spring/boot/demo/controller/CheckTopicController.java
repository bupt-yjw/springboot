package com.spring.boot.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
public class CheckTopicController {

    public static void main(String[] a) throws Exception {
        Connection conn = null;
        String sql;
        Class.forName("com.mysql.cj.jdbc.Driver");// 动态加载mysql驱动

        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:13309/3garticle", "3gteamuser",
                "newsclient2013@)!#");
        // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
        File file = new File("/Users/weiyongjun/Desktop/new.txt");

        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file));// 考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String line = null;
        int i = 0;
        String channelid = null;
        while ((line = bufferedReader.readLine()) != null) {
            i ++;
            if(i%10000==0) {
                System.out.println(i+"--"+line);
            }
            channelid = getChannelId(line, conn);
            if (!"0034".equals(channelid)) {
                System.out.println(line + "," + channelid);
            }
        }
        bufferedReader.close();
        read.close();

    }

    private static String selectByTopicid(String topicid, Connection conn) throws Exception {
        String sql = "select topictree as topictree from topic where topicid = '" + topicid + "\'";
        //sql = "select * from topic limit 10";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(sql);
        while (rs.next()) {
            return rs.getString("topictree");
        }
        return "weiyongjun";
    }


    public static String getChannelId(String topicId, Connection connection) {
        if (topicId.length() == 4) {
            return topicId;
        }
        if (topicId.endsWith("gd") && topicId.length() == 6) {
            return topicId.substring(0, 4);
        }
        try {
            String topictree = selectByTopicid(topicId, connection);
            if (StringUtils.isEmpty(topictree)) {
                return topicId.substring(0, 4);
            }
            String topicArray[] = topictree.split(";");
            if (topicArray.length > 3) {// 第三层目录为频道对应父目录
                String channelId = getChannelId(topicArray[2], connection);
                if (!StringUtils.isEmpty(channelId)) {
                    return channelId;
                }
            }

            return topicId.substring(0, 4);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
