package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-01 17:04
 */
public class HiServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //一定要调用父类的init方法，否则下面调用servlet配置方法将空指针
        super.init(config);
        System.out.println("重写了Init方法");
    }

    /**
     * 在Get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HiServlet doGet...");

        ServletConfig config = getServletConfig();
        System.out.println("Servlet的别称是：" + config.getServletName());
        System.out.println("Servlet的username是:" + config.getInitParameter("username"));
    }

    /**
     * 在Post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HiServlet doPost...");
    }
}
