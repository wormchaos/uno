/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ExceptionHandler.java
 * Author:   13071604
 * Date:     2014-8-5 下午2:35:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wormchaos.util.StringUtils;
import com.wormchaos.util.constant.UnoConfigConstants;
import com.wormchaos.util.constant.UnoErrConstants;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br> 
 * 异常处理
 *
 * @author 13071604
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
            if (StringUtils.isBlank(errorMsg)) {
                errorMsg = UnoErrConstants.ERROR_MSG_MAPPING.get(errorCode);
            }

        }
        model.addObject("errorMsg", errorMsg);
        return model;
    }

}
