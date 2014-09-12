/**
 * FileName: AopTest.java
 * Author:   wormchaos
 * Date:     2014-9-12 上午9:29:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wormchaos.service.IHelloWorldService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AopTest {
    @Test
    public void testHelloworld() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayHello();
    }
}
