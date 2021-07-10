package com.servlet;

import com.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 11:07
 */
public class CookieCreate extends BaseServlet {

    protected void deleteAllCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("pathKey", "pathValue");
        cookie.setPath(request.getContextPath() + "/abc");
        response.addCookie(cookie);
    }

    protected void newMLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie key3 = CookieUtil.findCookie("key3", request.getCookies());
        key3.setMaxAge(3600);
        response.addCookie(key3);
    }

    protected void deleteCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie key2 = CookieUtil.findCookie("key2", request.getCookies());
        key2.setMaxAge(0);
        response.addCookie(key2);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie key1 = CookieUtil.findCookie("key1", request.getCookies());
        key1.setMaxAge(-1);
        response.addCookie(key1);
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //方法一：
//        Cookie cookie = new Cookie("key1", "NewCookie1");
//        response.addCookie(cookie);

//        response.getWriter().write("Cookie值已修改");

        //方法二：
        Cookie[] cookies = request.getCookies();
        Cookie key3 = CookieUtil.findCookie("key3", cookies);
        if (key3 != null) {
            key3.setValue("NewValue3");
            response.addCookie(key3);
        }


    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

//        Cookie iWantCookie = null;

        for (Cookie cookie : cookies) {
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "];<br/>");
            //获取指定的Cookie
//            if ("key2".equalsIgnoreCase(cookie.getName())) {
//                iWantCookie = cookie;
//            }
        }
        Cookie key2 = CookieUtil.findCookie("key2", cookies);

        response.getWriter().write("我想得到的cookie是[" + key2.getName() + "=" + key2.getValue() + "];");

    }

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建单个Cookie
        //        Cookie cookie = new Cookie("key1", "value1");
        //通知客户端保存Cookie
//        response.addCookie(cookie);

        //创建多个Cookie
        Cookie cookie = new Cookie("key2", "value2");
        response.addCookie(cookie);

        Cookie cookie1 = new Cookie("key3", "value3");
        response.addCookie(cookie1);

        response.getWriter().write("创建Cookie成功！");
    }
}
