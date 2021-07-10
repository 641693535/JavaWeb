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
 * @Date 2021-07-01 22:19
 */
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        System.out.println("服务2得到请求的参数：" + username);

        //查询上一个服务是否已处理
        Object key1 = request.getAttribute("key1");
        System.out.println("服务2收到域数据：" + key1);

        //处理自己的业务
        System.out.println("服务2开始处理自己的业务~");

    }
}
