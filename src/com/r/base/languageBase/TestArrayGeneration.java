package com.r.base.languageBase;

import java.util.Arrays;

import com.r.util.ConverTo;
import com.r.util.Generated;
import com.r.util.RandomGenerator;

public class TestArrayGeneration {

	public static void main(String[] args) {
		int size = 6;
		boolean[] a1 = ConverTo.primitive(Generated.array(Boolean.class, new RandomGenerator.Boolean(),size));
		System.out.println("a1 = "+Arrays.toString(a1));
		byte[] a2 = ConverTo.primitive(Generated.array(Byte.class, new RandomGenerator.Byte(),size));
		System.out.println("a2 = "+Arrays.toString(a2));
		short[] a3 = ConverTo.primitive(Generated.array(Short.class, new RandomGenerator.Short(),size));
		System.out.println("a3 = "+Arrays.toString(a3));
		char[] a4 = ConverTo.primitive(Generated.array(Character.class, new RandomGenerator.Character(),size));
		System.out.println("a4 = "+Arrays.toString(a4));
		int[] a5 = ConverTo.primitive(Generated.array(Integer.class, new RandomGenerator.Integer(),size));
		System.out.println("a5 = "+Arrays.toString(a5));
		long[] a6 = ConverTo.primitive(Generated.array(Long.class, new RandomGenerator.Long(),size));
		System.out.println("a6 = "+Arrays.toString(a6));
		float[] a7 = ConverTo.primitive(Generated.array(Float.class, new RandomGenerator.Float(),size));
		System.out.println("a7 = "+Arrays.toString(a7));
		double[] a8 = ConverTo.primitive(Generated.array(Double.class, new RandomGenerator.Double(),size));
		System.out.println("a8 = "+Arrays.toString(a8));	
	}

}
