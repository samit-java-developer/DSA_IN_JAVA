package com.samit.mathematics;

public class PrimeFactorization {

	static void primeFactor(int n) {
		if (n <= 1)
			return;
		for (int i = 2; i < n; i++) {
			if (PrimeNo.isPrimeThirdWay(i)) {
				int x = i;
				while (n % x == 0) {
					System.out.print(i + " ");
					x = x * i;
				}
			}
		}
	}

	static void primeFactorOptimised(int n) {
		if (n <= 1)
			return;
		for (int i = 2; i*i <= n; i++) {
			while (n%i==0) {
				System.out.print(i+" ");
				n=n/i;
			}
		}
		if (n>1) System.out.println(n);
	}

	public static void main(String[] args) {
		int n = 9999;
		System.out.println("The prime factor of " + n + " is ");
		//primeFactor(n);
		primeFactorOptimised(n);
		System.out.println(3*3*11*101);
	}

}
