package test.spring.core;

import org.junit.Test;
import test.spring.core.context.ApplicationContext;
import test.spring.core.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
