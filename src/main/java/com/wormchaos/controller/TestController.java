/*
 * FileName: TestController.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午2:24:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.wormchaos.bean.Player;
import com.wormchaos.service.PlayerService;
import com.wormchaos.util.GsonView;
import com.wormchaos.util.constant.UnoErrConstants;
import com.wormchaos.util.constant.UnoJsonErrConstants;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class TestController extends BaseController {
    
    @Autowired
    PlayerService playerService;
    
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
    @RequestMapping("ajax/exception")
    public void ajaxException(HttpServletRequest request, HttpServletResponse response) throws IOException, UnoException{
        throw new UnoException(UnoJsonErrConstants.DEFAULT_ERROR);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 检查数据库是否正常
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("checkDB")
    public void checkDB(HttpServletRequest request, HttpServletResponse response) throws IOException, UnoException{
        Long roomId = 1L;
        List<Player> listByRoomId = playerService.queryListByRoomId(roomId);
        String json = new Gson().toJson(listByRoomId);
        response.getWriter().write(json);
    }
}
