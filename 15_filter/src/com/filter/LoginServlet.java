package com.filter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 18:05
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取用户名和密码
        String user = req.getParameter("user");
        String passwd = req.getParameter("passwd");
        if ("root".equals(user) && "123123".equals(passwd)) {
            //将用户名自动填充
            Cookie userCookie = new Cookie("user", user);
            resp.addCookie(userCookie);
            //创建Session域数据，让Filter过滤器知道已经登录
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/admin/a.jsp").forward(req, resp);
        }else{
            //账户名或密码错误 重新进入登陆界面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

}
