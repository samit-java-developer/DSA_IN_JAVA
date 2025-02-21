package com.samit.mathematics;

import java.util.Arrays;

public class SieveOfEratosthenes {

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

	public static void main(String[] args) {
		printPrime(20);
	}

}
