package com.servlet;

import javax.servlet.RequestDispatcher;
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
public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        System.out.println("服务1得到请求的参数：" + username);

        System.out.println("服务1开始处理自己的业务~");

        //使用域数据表示已处理
        request.setAttribute("key1", "Servlet1已处理~！");

        //表示下一个服务
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //请求转发可以转发到WEB-INF目录下
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/form.html");

        //传递给下一个服务进行处理
        requestDispatcher.forward(request, response);


    }
}
