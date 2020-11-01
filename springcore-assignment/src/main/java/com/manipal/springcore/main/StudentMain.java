package com.manipal.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manipal.springcore.bean.Student;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		Student student = container.getBean("student", Student.class);
		System.out.println(student);

	}

}
