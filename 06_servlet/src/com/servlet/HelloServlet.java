package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 14:22
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 Init初始化方法");

        System.out.println("Servlet程序的别名是:" + servletConfig.getServletName());

        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Service方法是专门用来处理请求和响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 Hello Servlet被访问了~！");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();
        if ("GET".equalsIgnoreCase(method)) {
            doGet();
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost();
        }

    }
    /**
     * 做Get请求的操作
     */
    public void doGet(){
        System.out.println("GET请求1");
        System.out.println("GET请求2");
        System.out.println("GET请求3");
    }

    /**
     * 做Post请求的操作
     */
    public void doPost(){
        System.out.println("POST请求1");
        System.out.println("POST请求2");
        System.out.println("POST请求3");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
