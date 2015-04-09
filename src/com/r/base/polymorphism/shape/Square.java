package com.r.base.polymorphism.shape;
import static com.r.util.Print.*;
public class Square extends Shape {

	@Override
	public void draw() {
		print("Square.draw()");
	}

	@Override
	public void erase() {
		print("Square.erase()");
	}

}
