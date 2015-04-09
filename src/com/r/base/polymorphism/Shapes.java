package com.r.base.polymorphism;

import com.r.base.polymorphism.shape.RandomShapeGenerator;
import com.r.base.polymorphism.shape.Shape;

public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args){
		Shape[] s = new Shape[9];
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();
		for(Shape shp : s)
			shp.a();;
	}
}
