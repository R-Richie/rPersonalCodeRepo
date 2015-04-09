package com.r.base.polymorphism.shape;
import static com.r.util.Print.*;
public class Triangle extends Shape{

	@Override
	public void draw() {
		print("Triangle.draw()");
	}

	public void erase() {
		print("Trangle.erase()");
	}
	
}
