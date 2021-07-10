package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 23:33
 */
public class ResponseIOSServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应的字符集
//        resp.setCharacterEncoding("UTF-8");
        //告诉用户客户端浏览器我所响应的字符集
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");

        //设置响应的字符集，并且告诉浏览器我所使用的字符集
        //此方法一定要在获取流前使用才有效
        resp.setContentType("text/html;charset=UTF-8");

        //获取响应的字符流
        PrintWriter writer = resp.getWriter();
        writer.write("你好，世界！");

    }
}
