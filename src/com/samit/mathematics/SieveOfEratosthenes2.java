package com.samit.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	static List<Integer> primesInRange(int n){
		boolean[] isPrime=new boolean[n+1];
		Arrays.fill(isPrime,true);
		List<Integer> list=new ArrayList<>();
		for (int i=2;i*i<=n;i++){
			if (isPrime[i]){
				for (int j=i*2;j<=n;j=j+i){
					isPrime[j]=false;
				}
			}
		}
		for (int i=2;i<=n;i++){
			if (isPrime[i]) list.add(i);
		}
		return list;
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

		System.out.println();

		List<Integer> list=primesInRange(25);
		list.forEach(x->System.out.print(x+" "));

	}

}
