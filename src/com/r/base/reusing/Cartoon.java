package com.r.base.reusing;
import static com.r.util.Print.*;

class Art{
	Art() {print("Art constructor");}
}

class Drawing extends Art{
	Drawing() {print("Drawing constructor");}
}
public class Cartoon extends Drawing{
	public Cartoon() {print("Cartoon constructor");}
	public static void main(String[] args){
		Cartoon x = new Cartoon();
	}
}
