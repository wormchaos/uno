/**
 * FileName: ColorEnum.java
 * Author:   wormchaos
 * Date:     2014-8-6 下午7:02:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto.enu;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum CardColor {
    red {
        public String toString(){
            return "red";
        }
    },
    blue {
        public String toString(){
            return "blue";
        }
    },
    yellow {
        public String toString(){
            return "yellow";
        }
    },
    green {
        public String toString(){
            return "green";
        }
    }
}
