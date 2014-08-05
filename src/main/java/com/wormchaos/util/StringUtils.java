/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: StringUtils.java
 * Author:   13071604
 * Date:     2014-8-5 下午4:55:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author 13071604
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
