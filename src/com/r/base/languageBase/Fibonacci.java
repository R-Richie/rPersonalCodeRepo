package com.r.base.languageBase;

public class Fibonacci {
	public static void printFibonacci(int count){
		for(int i = 1 ; i<= count ;i++){
			System.out.print(returnOneFibonacci(i)+" ");
		}
	}
	public static int returnOneFibonacci(int statement){
		int oneF = 0;
		if(statement == 1 || statement == 2){
			oneF = 1;
		}else{
			oneF = returnOneFibonacci(statement-2)+returnOneFibonacci(statement-1);
		}
		return oneF;
	}
	public static void main(String[] args) {
		printFibonacci(5);

	}

}
