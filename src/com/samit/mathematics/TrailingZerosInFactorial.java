package com.samit.mathematics;

public class TrailingZerosInFactorial {
	
	static int countZeros(int n) {
		int fact=1;
		for (int i=2;i<=n;i++) {
			fact=fact*i;
		}
		int res=0;
		while (fact%10==0) {
			res++;
			fact=fact/10;
		}
		return res;
	}
	
	static int countZerosInEfficentWay(int n) {
		int res=0;
		for (int i=5;i<=n;i=i*5) {
			res=res+n/i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(countZerosInEfficentWay(125));
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
