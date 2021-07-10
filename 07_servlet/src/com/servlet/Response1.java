package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 23:45
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1到此一游");
        //设置响应状态码
//        resp.setStatus(302);
//        //设置响应头信息中的新地址
//        resp.setHeader("location", "http://localhost:8080/07_servlet/response2");
        //第二种重定向方式
        resp.sendRedirect("http://localhost:8080/07_servlet/response2");
    }
}
