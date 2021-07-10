package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 19:01
 */
public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行前置代码1");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("执行后置代码1");
    }
}
