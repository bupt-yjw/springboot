package com.spring.boot.demo.algorithm.june;


import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
  */
public class Filter_Test {
    public static void main(String[] a) {
        Request request = new Request();
        request.str = "大家好，<script> 这是敏感词";
        Response response = new Response();
        response.str="response";
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("<","[").replace(">","]")+ " HTMLFilter()";
        chain.doFilter(request, response);
        response.str+="--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("敏感词","非敏感词")+ " sensitiveFilter()";
        chain.doFilter(request, response);
        response.str+="--sensitiveFilter()";
        return true;
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int pos = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }


    public boolean doFilter(Request request, Response response) {
        if(pos == filters.size()) {
            return false;
        }
        Filter filter = filters.get(pos++);
        return filter.doFilter(request, response, this);
    }


}
