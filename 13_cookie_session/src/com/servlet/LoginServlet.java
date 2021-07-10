package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 14:51
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");

        if ("root".equals(username) && "123123".equals(passwd)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);

            resp.getWriter().write("登陆成功~！");
        }else{
            resp.getWriter().write("登录失败！！！");
        }
    }
}
