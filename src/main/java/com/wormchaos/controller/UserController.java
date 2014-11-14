/**
 * FileName: UserController.java
 * Author:   wormchaos
 * Date:     2014-8-18 上午10:29:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wormchaos.service.UserService;
import com.wormchaos.util.StringUtils;
import com.wormchaos.util.UserUtils;
import com.wormchaos.util.constant.UnoConstants;
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
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 登陆页
     */
    private static final String LOGIN_PAGE = "login";

    /**
     * 登陆成功页
     */
    private static final String LOGIN_SUCCESS_PAGE = "index";

    /**
     * 注册页
     */
    private static final String REGISTER_PAGE = "register";

    /**
     * 
     * 功能描述: <br>
     * 登录
     * 
     * @param request
     * @param response
     * @param user
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "referer", required = false) String referer) throws UnoException {

        ModelAndView model = new ModelAndView(LOGIN_PAGE);
        // 检查参数，如果为空，跳转到登陆页
        if (null == username && null
                == password) {
            model.addObject(UnoConstants.REFERER, referer);
            return model;
        }
        Long userId = userService.checkUserExists(username, password);
        if (userId != null) {
            // 用户存在
            // 获取token并set进cookie
            String token = UserUtils.login(userId.toString());
            Cookie cookie = new Cookie(UnoConstants.TOKEN, token);
            cookie.setPath("/");
            response.addCookie(cookie);
            // TODO 这部分的判断并不完全
            if (StringUtils.isBlank(referer) || referer.contains(LOGIN_PAGE)) {
                model.setViewName(LOGIN_SUCCESS_PAGE);
            }
        } else {
            model.addObject(UnoConstants.USERNAME, username);
        }
        return model;
    }

}
