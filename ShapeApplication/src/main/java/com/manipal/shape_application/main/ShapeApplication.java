package com.manipal.shape_application.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manipal.shape_application.bean.Line;
import com.manipal.shape_application.bean.Triangle;

public class ShapeApplication {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		Line line = container.getBean("line", Line.class);
		System.out.println("Line Coordinates: "+"("+line.getPoint1().getX()+","+line.getPoint1().getY()+")"+", ("+line.getPoint2().getX()+","+line.getPoint2().getY()+")");
		
		Triangle triangle = container.getBean("triangle", Triangle.class);
		System.out.println("Triangle Coordinates: "+"("+triangle.getPoint1().getX()+","+triangle.getPoint1().getY()+")"+", ("+triangle.getPoint2().getX()+","+triangle.getPoint2().getY()+")"+", ("+triangle.getPoint3().getX()+","+triangle.getPoint3().getY()+")");

	}

}
