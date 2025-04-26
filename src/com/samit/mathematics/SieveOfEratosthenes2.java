package com.samit.mathematics;

import java.util.Arrays;

public class SieveOfEratosthenes2 {

	static void printPrime(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int i = 2; i * i <= n; i++) {
			if (prime[i] == true) {
				for (int k = i * i; k <= n; k += i) {
					prime[k] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (prime[i])
				System.out.print(i + " ");
		}

	}

	public static int exactly3Divisors(int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);

		for (int i = 2; i * i <= N; i++) {
			if (prime[i] == true) {
				for (int k = i * i; k <= N; k += i) {
					prime[k] = false;
				}
			}
		}
		int exactly3Divisor = 0;
		for (int i = 2; i <= N; i++) {
			if (prime[i] == true) {
				if (Math.pow(i, 2) <= N) {
					exactly3Divisor++;
				}
			}
		}
		return exactly3Divisor;
	}

	public static void main(String[] args) {
		// printPrime(67);
		System.out.println(exactly3Divisors(67));

		System.out.println((double)87 / 83);

	}

}
