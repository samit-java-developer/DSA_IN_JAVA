package com.samit.array.test;

public class MaximumCircularSubArray {

	public static void main(String[] args) {
		int[] arr = { 5, -2, 3, 4 };
		// maximumCircularSubArray(arr);
		printCirculerSubArray(arr);
	}

	static void printCirculerSubArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < n; j++) {
				int k = i;
				while (true) {
					System.out.print(arr[k] + " ");
					if (k == (i + j) % n) {
						break;
					}
					k = (k + 1) % n;
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
