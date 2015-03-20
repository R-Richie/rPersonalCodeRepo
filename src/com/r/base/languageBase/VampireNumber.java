package com.r.base.languageBase;

import java.util.Arrays;


/** 
 吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得，而这对数字 
 各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序。 
 以两个0结尾的数字是不允许的。 
 例如，下面数字都是吸血鬼数字： 
 1260 = 21 * 60 
 1827 = 21 * 87 
 2187 = 27 * 81 
 写一个程序，找出4位数的所有吸血鬼数字。 
 */
public class VampireNumber {

	public static void main(String[] args) {
		
		for(int i = 12 ;i<=99;i++){
			label:
			for(int j = 12; j <=99;j++){
				int sum = i*j;
				int i10 = i/10;
				int i1 = i %10;
				int j10 = j/10;
				int j1 = j%10;
				int sum1000 = sum/1000;
				int sum100 = sum%1000/100;
				int sum10 = sum%100/10;
				int sum1 = sum%10;
				int[] one = {i10,i1,j10,j1};
				int[] two = {sum1000,sum100,sum10,sum1};
				Arrays.sort(one);
				Arrays.sort(two);
//				System.out.println(one[0]+"|"+one[1]+"|"+one[2]);
				for(int k = 0; k<4;k++){
					if(one[k]!=two[k])
						continue label;
				}
				System.out.println(sum+"="+i+"*"+j);
				
			}
		}

	}

}
