package com.r.base.reusing;

class Poppet {
	private int i;
	Poppet(int ii){ i = ii;}
}

public class BlankFinal {
	private final int i = 0;// Initialized final
	private final int j; //Blank final
	private final Poppet p;//Blank final reference
	
	public BlankFinal(){
		j = 1;
		p = new Poppet(1);
	}
	public BlankFinal(int x){
		j = x;
		p = new Poppet(1);
	}
	public static void main(String[] args){
		new BlankFinal();
		new BlankFinal(47);
	}
}
