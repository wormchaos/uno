/**
 * FileName: UserService.java
 * Author:   wormchaos
 * Date:     2014-8-18 上午10:40:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserService {

    /**
     * 
     * 功能描述: <br>
     * 检查用户是否存在
     * 存在:返回userId ; 不存在:返回null
     *
     * @param userName
     * @param password
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long checkUserExists(String userName, String password);
}
