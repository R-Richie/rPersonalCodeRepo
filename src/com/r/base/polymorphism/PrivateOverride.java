package com.r.base.polymorphism;
import static com.r.util.Print.*;

public class PrivateOverride {
	private void f() {print("private f()");}
	public static void main(String[] args) {
		PrivateOverride po = new PrivateOverride();
		po.f();
	}

}

class Derived extends PrivateOverride{
	public void f() {print("public f()");}
}