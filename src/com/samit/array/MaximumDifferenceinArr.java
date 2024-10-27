package com.samit.array;


public class MaximumDifferenceinArr {

	// arr[j]-arr[i] and j>i
	static int maxDiff(int[] arr) {
		int res = arr[1] - arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				res = Math.max(res, arr[j] - arr[i]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(maxDiff(arr));
	}

}
