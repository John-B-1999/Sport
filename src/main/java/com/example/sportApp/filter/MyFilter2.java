package com.example.sportApp.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(1)
@WebFilter(urlPatterns = "/user/*",filterName = "MyFilter2")
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2222222222");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2 start");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2 end");
    }

    @Override
    public void destroy() {
        System.out.println("Filter2 destroy");
    }
}
