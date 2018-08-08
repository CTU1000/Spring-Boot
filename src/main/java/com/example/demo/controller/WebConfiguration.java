package com.example.demo.controller;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/8 0008
 */
@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remotelpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName","paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter{

        /**
         * 初始化
         * @param filterConfig
         * @throws ServletException
         */
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        /**
         * 过滤
         * @param request
         * @param response
         * @param chain
         * @throws IOException
         * @throws ServletException
         */
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request1 = (HttpServletRequest) request;
            System.out.println("This is MyFilter,url:"+request1.getRequestURI());
            chain.doFilter(request,response);
        }

        /**
         * 销毁
         */
        @Override
        public void destroy() {

        }
    }
}
