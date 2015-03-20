//给出半径，可以打印出一个圆形
package com.r.base.languageBase;

public class PrintCircle {
	public static void circle(int radius){
		
		//上半球
		for (int i = 0; i <= radius; i++) {
			double length2 = Math.sqrt(Math.pow(radius,2)-Math.pow(radius-i,2));
			double length1 = radius - length2;
			printBlank(Math.round(length1)*2);
			System.out.print("*");
			printBlank((Math.round(length2)*4));
			System.out.println("*");
		}
		//下半球
		for (int i = radius; i >= 0; i--) {
			double length2 = Math.sqrt(Math.pow(radius,2)-Math.pow(radius-i,2));
			double length1 = radius - length2;
			printBlank(Math.round(length1)*2);
			System.out.print("*");
			printBlank((Math.round(length2)*4));
			System.out.println("*");
			
		}
	}
	public static void printBlank(long length){
		for (int i = 0; i < length; i++) {
			System.out.print(" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circle(8);
	}

}
