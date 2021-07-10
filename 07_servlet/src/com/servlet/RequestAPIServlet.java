package com.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 21:17
 */
public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //先进行请求，在设置字符集则不能解决乱码
        String passwd = req.getParameter("passwd");

        //解决中文Post乱码问题
        //!!!要在调用所有参数之前使用才有效果
        req.setCharacterEncoding("UTF-8");

        //获取一个参数
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("passwd"));
        System.out.println("邮箱：" + req.getParameter("email"));
        System.out.println("兴趣爱好：" + req.getParameter("hobby"));

        //获取多个参数
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("兴趣爱好:" + Arrays.toString(hobbies));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println(req.getRequestURI());

        //获取请求的统一资源定位符(绝对路径)
        System.out.println(req.getRequestURL());

        //获取客户端的ip地址
        System.out.println(req.getRemoteHost());

        //获取请求头
        System.out.println(req.getHeader("Connection"));

        //获取请求的方式（Get/Post)
        System.out.println(req.getMethod());
    }
}
