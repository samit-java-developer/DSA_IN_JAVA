package com.samit.mathematics;

import java.util.Arrays;

public class PrintPrimes {

	static void printPrimesNaive(int n) {
		for (int i = 2; i <= n; i++) {
			if (PrimeNo.isPrimeThirdWay(i))
				System.out.print(i + " ");
		}
	}

	static void printPrimePractice(int n){
		for (int i=2;i<=n;i++){
			if (PrimeNo.isPrimeThirdWay(i)){
				System.out.print(i+" ");
			}
		}
		System.out.println();
		boolean[] arr=new boolean[n+1];
		Arrays.fill(arr,true);
		for (int i=2;i*i<=n;i++){
			if (arr[i]){
				for (int j=i*2;j<=n;j=j+i){
					arr[j]=false;
				}
			}
		}
		for (int i=2;i<=n;i++){
			if (arr[i]){
				System.out.print(i+" ");
			}
		}
		System.out.println();
		boolean[] arr2=new boolean[n+1];
		Arrays.fill(arr2,true);
		for (int i=2;i<=n;i++){
			if (arr2[i]){
				System.out.print(i+" ");
				for (int j=i*i;j<=n;j=j+i){
					arr2[j]=false;
				}
			}
		}
	}

	static void printPrimeUsingSieve(int n) {
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		for (int i = 2; i * i <= n; i++) {
			if (arr[i]) {
				for (int j = 2 * i; j <= n; j = j + i) {
					arr[j] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i])
				System.out.print(i + " ");
		}
	}

	static void printPrimeUsingSieveMostOptimisedWay(int n) {
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		for (int i = 2; i <= n; i++) {
			if (arr[i]) {
				System.out.print(i+" ");
				for (int j = i * i; j <= n; j = j + i) {
					arr[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		printPrimesNaive(100);
		System.out.println();
		printPrimeUsingSieve(100);
		System.out.println();
		printPrimeUsingSieveMostOptimisedWay(100);

		System.out.println("\n");
		printPrimePractice(100);
	}
}
