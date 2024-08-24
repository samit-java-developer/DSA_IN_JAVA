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
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
		}
		if (n > 1)
			System.out.println(n);
	}

	static void primeFactorMostOptimised(int n) {
		if (n <= 1)
			return;
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n = n / 2;
		}
		while (n % 3 == 0) {
			System.out.print(3 + " ");
			n = n / 3;
		}
		for (int i = 5; i * i <= n; i = i + 6) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
			while (n % (i + 2) == 0) {
				System.out.print(i + 2 + " ");
				n = n / (i + 2);
			}
		}
		if (n>3) {
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		int n = 9999;
		System.out.println("The prime factor of " + n + " is ");
		// primeFactor(n);
		//primeFactorOptimised(n);
		primeFactorMostOptimised(n);
		System.out.println(3 * 3 * 11 * 101);
	}

}
