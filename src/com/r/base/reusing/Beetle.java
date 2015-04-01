package com.r.base.reusing;
import static com.r.util.Print.*;
class Insect{
	private int i = 9;
	protected int j;
	Insect(){
		print("i = "+i+", j = "+j);
		j = 39;
	}
	private static int x1 = printInit("static Insect.x1 initalized");
	static int printInit(String s){
		print(s);
		return 47;
	}
}
public class Beetle extends Insect{
	private int k = printInit("Beetle.k initialized");
	public Beetle(){
		print("k = "+k);
		print("j = "+j);
	}
	private static int x2 = printInit("static Beetle.x2 initialized");
	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
	}

}
//static Insect.x1 ini
//static Beetle.x2
//Beetle constructor
//i = 9,j = 0
// k = 47,j = 39