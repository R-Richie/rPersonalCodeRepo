package com.r.base.interfaces;

interface I1 {void f();}
interface I2 {int f(int i);}
interface I3 { int f();}
class C {public int f(){return 1;}}
class C2 implements I1,I2{

	public int f(int i) {
		return 1;
	}
	public void f() {}
	
}

class c3 extends C implements I2 {
	public int f(int i) {
		return 1;
	}
}
class c4 extends C implements I3 {
	public int f(){ return 1;}
}
//class c5 extends C implements I1 {}
//interface I4 extends I1,I3 {}
public class InterfaceCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
