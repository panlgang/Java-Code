package com.xust.excellent;

import com.xust.excellent.injection.Bean1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther plg
 * @date 2019/7/25 22:14
 */
public class BeanTest {

    private ApplicationContext context;
    @Before
    public void testInitial(){
        context = new ClassPathXmlApplicationContext("application-Context-Bean.XML");
    }
    @Test
    public void testtoString(){
        Bean1 bean = (Bean1) context.getBean("bean1");
        System.out.println(bean);
    }
}
