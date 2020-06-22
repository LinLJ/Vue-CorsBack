package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 林炼钧
 * @date 2020/6/22 15:40
 */
@Component
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String origin = httpRequest.getHeader("origin");
        // 直接从request中获取并设置到response中
        if (!"".equals(origin) && origin != null) {
            httpResponse.addHeader("Access-Control-Allow-Origin", origin);
        }
  /*Enumeration enum1 = httpRequest.getHeaderNames();
  System.out.println("-----------header----------------->");
  while (enum1.hasMoreElements()) {
   String key = (String) enum1.nextElement();
   String value = httpRequest.getHeader(key);
   System.out.println(key + ":" + value);
  }
  System.out.println("<-----------header-----------------");
  String headers = httpRequest.getHeader("Access-Control-Request-Headers");
  System.out.println("dd" + headers);
  // 支持所有自定义的方法头
  if (!"".equals(headers) && headers != null) {
   httpResponse.addHeader("Access-Control-Allow-Headers", headers);
  }
  */
        // 指定特定的域，带cookie的请求需要全匹配
        // httpResponse.addHeader("Access-Control-Allow-Origin",
        // "http://127.0.0.1:8090");
        // 带cookie请求时需要在请求头增加该参数值
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        // 指定所有的域,为*时不能满足带cookie的请求
        // httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        // 指定特定的方法
        // httpResponse.addHeader("Access-Control-Allow-Methods", "GET");
        // 指定所有的方法
        httpResponse.addHeader("Access-Control-Allow-Methods", "*");
        // 当有options预检命令时
        // httpResponse.addHeader("Access-Control-Allow-Headers",
        // "Content-Type,x-header1,x-header2");
        // 预命令的缓存时间
        httpResponse.addHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
