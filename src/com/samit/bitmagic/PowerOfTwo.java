package com.samit.bitmagic;

public class PowerOfTwo {

	static boolean isPowerOfTwo(int n) {
		if (n == 0) {
			return false;
		}
		return ((n & (n - 1)) == 0);
	}

	static boolean naiveSolution(int n){
		if (n==0){
			return false;
		}
		while (n!=1){
			if (n%2!=0){
				return false;
			}
			n=n/2;
			if (n==1){
				return  true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(6));
		System.out.println(naiveSolution(6));
	}

}
