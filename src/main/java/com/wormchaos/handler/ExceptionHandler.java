/*
 * FileName: ExceptionHandler.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午2:35:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wormchaos.util.GsonView;
import com.wormchaos.util.StringUtils;
import com.wormchaos.util.constant.UnoConfigConstants;
import com.wormchaos.util.constant.UnoConstants;
import com.wormchaos.util.constant.UnoErrConstants;
import com.wormchaos.util.constant.UnoJsonErrConstants;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br> 
 * 异常处理
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExceptionHandler implements HandlerExceptionResolver{

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ModelAndView model = new ModelAndView(UnoConfigConstants.DEFAULT_EXCEPTION_PAGE);
        // 默认错误码
        String errorCode = UnoErrConstants.DEFAULT_ERROR;
        String errorMsg = UnoErrConstants.ERROR_MSG_MAPPING.get(errorCode);
        
        // 检查Uno异常类型
        if (ex instanceof UnoException) {

            // 业务层错误信息
            UnoException exception = (UnoException) ex;
            errorCode = exception.getErrorCode();
            errorMsg = exception.getMessage();

            if (StringUtils.isBlank(errorCode)) {
                errorCode = UnoErrConstants.DEFAULT_ERROR;
            }
            
            // 如果错误是用户需要登录，则重定向
            if(errorCode.equals(UnoErrConstants.USER_NEED_LOGIN)){
                try {
                    response.sendRedirect("/uno/login.do");
                } catch (IOException e) {
                    // do nothing
                }
            }
            
            // 如果ajax请求异常返回json
            if(UnoException.isJsonException(errorCode)){
                // 返回GsonView
                GsonView gsonView = new GsonView();
                if (StringUtils.isBlank(errorMsg)) {
                    errorMsg = UnoJsonErrConstants.ERROR_MSG_MAPPING.get(errorCode);
                }
                gsonView.addStaticAttribute(UnoConstants.SUCCESS_FLG, UnoConstants.FAILED);
                gsonView.addStaticAttribute(UnoConstants.ERROR_CODE, errorCode);
                gsonView.addStaticAttribute(UnoConstants.ERROR_MSG, errorMsg);
                model.setView(gsonView);
                return model;
            }else{
                if (StringUtils.isBlank(errorMsg)) {
                    errorMsg = UnoErrConstants.ERROR_MSG_MAPPING.get(errorCode);
                }
                model.addObject(UnoConstants.ERROR_CODE, errorCode);
                model.addObject(UnoConstants.ERROR_MSG, errorMsg);
            }

        }
        
        return model;
    }
    
}
