/**
 * FileName: BeanUtil.java
 * Author:   wormchaos
 * Date:     2014-11-14 下午12:05:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanUtil {

    /**
     * 
     * 功能描述: <br>
     * bean转map
     *
     * @param source
     * @param target
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> void copyProperties(T source, Map<String, Object> target) {
        Class<?> clazz = source.getClass();
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            try {
                Object value = field.get(source);
                if (null != value) {
                    target.put(key, value);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
