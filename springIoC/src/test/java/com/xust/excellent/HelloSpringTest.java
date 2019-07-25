package com.xust.excellent;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther plg
 * @date 2019/7/25 21:17
 */
public class HelloSpringTest {
    private ApplicationContext context;
    @Before
    public void testInitial(){
        context = new ClassPathXmlApplicationContext("application-Context.XML");
    }

    @Test
    public void testPrint(){
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        System.out.println(helloSpring);
    }



}
