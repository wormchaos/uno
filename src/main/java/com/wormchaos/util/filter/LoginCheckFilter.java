/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: LoginCheckFilter.java
 * Author:   13071604
 * Date:     2014-8-5 下午5:26:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoginCheckFilter implements Filter {

    private static final String LOGIN_URI = "/uno/login";

    private static final String COOKIE_ID = "userId";

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 如果不是登录页面则判断是否登录
        if(isNotLoginPage(httpRequest)){
            if(isLogin(httpRequest)){
                chain.doFilter(httpRequest, httpResponse);
            }else{
                // 重定向到登录页面
                httpResponse.sendRedirect(LOGIN_URI);
            }
        }
        
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     * 功能描述: <br>
     * 当前访问页是否是登录相关页
     *
     * @param httpRequest
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private boolean isNotLoginPage(HttpServletRequest httpRequest) {
        // TODO 后期会加入注册页面 也需要匹配
        return httpRequest.getRequestURI().startsWith(LOGIN_URI) ? false : true;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 检查用户是否登录
     *
     * @param httpRequest
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private boolean isLogin(HttpServletRequest httpRequest){
        Cookie[] cookies = httpRequest.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(COOKIE_ID)){
                // TODO 检查是否是合法的用户
                return true;
            }
        }
        return false;
    }

}
