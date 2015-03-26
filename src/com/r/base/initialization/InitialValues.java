package com.r.base.initialization;

public class InitialValues {
	boolean t;
	byte b;
	char c;
	short s;
	int i;
	long l;
	double d;
	float f;
	InitialValues reference;
	void printInitialValue(){
		System.out.println("Data type		Initial value");
		System.out.println("boolean			"+t);
		System.out.println("char			["+c+"]");
		System.out.println("byte			"+b);
		System.out.println("short			"+s);
		System.out.println("int				"+i);
		System.out.println("long			"+l);
		System.out.println("float			"+f);
		System.out.println("double			"+d);
		System.out.println("reference		"+reference);
	}
	public static void main(String[] args) {
		InitialValues iv = new InitialValues();
		iv.printInitialValue();
	}

}
