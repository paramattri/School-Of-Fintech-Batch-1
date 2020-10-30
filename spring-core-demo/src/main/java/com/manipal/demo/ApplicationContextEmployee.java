package com.manipal.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manipal.bean.Employee;

public class ApplicationContextEmployee {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp1 = container.getBean("employee1", Employee.class);
		Employee emp2 = container.getBean("employee2", Employee.class);
		System.out.println(emp1.getEmpName()+" "+emp1.getEmpId()+" "+emp1.getSalary());
		System.out.println(emp2.getEmpName()+" "+emp2.getEmpId()+" "+emp2.getSalary());
	}

}
