package com.manipal.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import com.manipal.bean.Welcome;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        //Welcome welcome = (Welcome) container.getBean("welcome");
        Welcome welcome = container.getBean("welcome", Welcome.class); // Another method
        System.out.println(welcome.getMessage());
        
    }
}
