package com.samit.bitmagic;

import java.util.Scanner;

public class CheckKthBitIsSetOrNot {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int x=(int)Math.pow(2,k-1);
		System.out.println(x);
		if ((n&x)!=0){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}


}
