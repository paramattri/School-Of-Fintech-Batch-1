package com.manipal.dp.structural.decorator;

public class DecoratorPatternDemo {
	
	public static void main(String[] args) {
		
		Color borderColor = Color.BLACK;
		Color fillColor = Color.RED;
		
		Shape shape = new Circle();
		Shape redBlackCircle = new EnumShapeDecorator(shape, borderColor, fillColor);
		redBlackCircle.draw();
		
		Shape redBlackRectangle = new EnumShapeDecorator(new Rectangle(), borderColor, fillColor);
		redBlackRectangle.draw();
		
	}

}
