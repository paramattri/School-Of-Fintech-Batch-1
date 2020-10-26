package com.manipal.dp.structural.decorator;

public class EnumShapeDecorator extends ShapeDecorator{
	
	Color borderColor;
	Color fillColor;
	
	public EnumShapeDecorator(Shape decoratedShape, Color borderColor, Color fillColor) {
		super(decoratedShape);
		this.borderColor = borderColor;
		this.fillColor = fillColor;
	}

	@Override
	public void draw() {
		this.decoratedShape.draw();
		setBackgroundColor(decoratedShape, borderColor);
	}
	
	public void setBackgroundColor(Shape decoratedShape, Color borderColor) {
		
		System.out.println("Shape Border Color: "+borderColor);
	}
	
	public void setFillColor(Shape decoratedShape, Color fillColor) {
		
		System.out.println("Shape Fill Color: "+fillColor);
	}
	
}
