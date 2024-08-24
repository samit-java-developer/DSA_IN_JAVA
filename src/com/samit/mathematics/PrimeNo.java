package com.samit.mathematics;

public class PrimeNo {

	static boolean isPrimeFirstWay(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPrimeSecondWay(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	//more efficient way for large n
	static boolean isPrimeThirdWay(int n) {
		if (n == 1) return false;
		if (n==2||n==3) return true;
		if (n%2==0 || n%3==0)return false;
		for (int i = 5; i*i <= n; i=i+6) {
			if (n % i == 0 || n%(i+2)==0)return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 113;
		System.out.println("To check prime via first way, the no is " + n +": "+ isPrimeFirstWay(n));
		System.out.println("To check prime via second way, the no is " + n +": "+ isPrimeSecondWay(n));
		System.out.println("To check prime via third way, the no is " + n +": "+ isPrimeThirdWay(n));
	}

}
