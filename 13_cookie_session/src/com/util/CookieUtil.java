package com.util;

import javax.servlet.http.Cookie;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 11:51
 */
public class CookieUtil {

    /**
     * 查找指定名称的Cookie对象
     * @param name 指定名称
     * @param cookies Cookie数组
     * @return 返回指定key名称的cookie
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
        }else{
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

}
