/*
 * FileName: LoginCheckFilter.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午5:26:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wormchaos.util.UserUtils;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoginCheckFilter implements Filter {

    private static final String LOGIN_URI = "/uno/user/login.do";

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
        if (isNotLoginPage(httpRequest)) {
            if (!isLogin(httpRequest)) {
                // 重定向到登录页面
                // httpResponse.addHeader(UnoConstants.REFERER, httpRequest.getHeader(UnoConstants.REFERER));
                httpResponse.sendRedirect(LOGIN_URI + "?referer="
                        + URLEncoder.encode(httpRequest.getRequestURL().toString(), "utf-8"));
                return;
            }
        }
        chain.doFilter(httpRequest, httpResponse);
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
    private boolean isLogin(HttpServletRequest httpRequest) {
        try {
            String userId = UserUtils.queryUserId(httpRequest);
            if (null != userId) {
                return true;
            }
        } catch (UnoException e) {
            e.printStackTrace();
        }
        return false;
    }

}
