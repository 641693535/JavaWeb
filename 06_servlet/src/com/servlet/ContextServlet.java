package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 18:35
 */
public class ContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取上下文参数配置的context-param
        ServletContext con = getServletConfig().getServletContext();
        Object username = con.getInitParameter("username");
        System.out.println("Context的username是：" + username);
        Object password = con.getInitParameter("password");
        System.out.println("Context的password是：" + password);

        //2 获取当前工程的路径,格式：/工程路径
        String contextPath = con.getContextPath();
        System.out.println(contextPath);

        //3 获取工程部署在硬盘上的绝对路径
        System.out.println("工程部署的绝对路径是:" + con.getRealPath("/"));

        System.out.println("工程下css目录的绝对路径是:" + con.getRealPath("/css"));
        System.out.println("工程下imgs目录1.jpg的绝对路径是:" + con.getRealPath("/imgs/1.jpg"));
    }
}
