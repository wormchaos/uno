/*
 * FileName: StringUtils.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午4:55:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

/**
 * 〈一句话功能简述〉<br>
 * String公共操作
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return null == str || str.equals("") ? true : false;
    }

    public static boolean isNotBlank(String str) {
        return null == str || str.equals("") ? false : true;
    }
    
}
