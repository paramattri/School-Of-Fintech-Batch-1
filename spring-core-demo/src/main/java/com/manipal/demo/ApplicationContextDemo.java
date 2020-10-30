package com.manipal.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manipal.bean.Welcome;

public class ApplicationContextDemo {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		Welcome welcome = container.getBean("welcome", Welcome.class);
        System.out.println(welcome.getMessage());

	}

}
