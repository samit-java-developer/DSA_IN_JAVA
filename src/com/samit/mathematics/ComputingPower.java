package com.samit.mathematics;

public class ComputingPower {
	
	static int power(int x,int n) {
		int res=1;
		for(int i=0;i<n;i++) {
			res=res*x;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(power(11, 11));
	}

}
