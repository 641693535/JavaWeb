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
 * @Date 2021-07-01 23:11
 */
public class ForwardC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/a/b/c.html").forward(req, resp);
    }
}
