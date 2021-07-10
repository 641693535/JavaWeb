package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 15:34
 */
public class SessionServlet extends  BaseServlet {

    protected void deleteSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("已删除Session！");
    }

    protected void Time3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        response.getWriter().write("Session默认超时时间成功设置为3秒");
    }

    protected void defaultTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("Session默认超时时间为：" + maxInactiveInterval);
    }

    protected void setAttr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("session1", "Session1..Values1!...");
    }

    protected void getAttr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object session1 = request.getSession().getAttribute("session1");
        response.getWriter().write("session1的域数据值为:" + session1);
    }

    protected void createGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session
        HttpSession session = request.getSession();
        //判断是否为新创建的
        String isNew = (session.isNew()) ? "是" : "不是";
        //获取Session唯一的标识Id
        String id = session.getId();

        //输出到浏览器上
        PrintWriter writer = response.getWriter();
        writer.write("获取到了Session，它的Id是：" + id + "。<br/>");
        writer.write("这个Session" + isNew + "新创建的。<br/>");

    }
}
