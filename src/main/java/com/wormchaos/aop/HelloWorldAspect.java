/**
 * FileName: HelloWorldAspect.java
 * Author:   wormchaos
 * Date:     2014-9-11 下午5:48:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.aop;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloWorldAspect {
    // 前置通知
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }

    // 后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }
}
