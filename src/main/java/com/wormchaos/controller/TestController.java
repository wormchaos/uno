/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: TestController.java
 * Author:   13071604
 * Date:     2014-8-5 下午2:24:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wormchaos.util.constant.UnoErrConstants;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class TestController {
    
    /**
     * 
     * 功能描述: <br>
     * 测试接口是否调通
     *
     * @param request
     * @param response
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.getWriter().write("it's a test interface !");
    }
    
    /**
     * 
     * 功能描述: <br>
     * 测试异常处理
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("exception")
    public void exception(HttpServletRequest request, HttpServletResponse response) throws IOException, UnoException{
        throw new UnoException(UnoErrConstants.DEFAULT_ERROR);
    }
}
