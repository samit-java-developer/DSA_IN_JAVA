package com.samit.array;

public class MaximumDifferenceinArr2 {

	// arr[j]-arr[i] and j>i
	static int maxDiff(int[] arr) {
		int res = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = Math.max(res, arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(maxDiff(arr));
	}

}
