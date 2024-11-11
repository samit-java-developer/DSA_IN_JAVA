package com.samit.array;

public class MaximumSubArray {

	static int maxSubArr(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int curr = 0;
			for (int j = i + 1; j < arr.length; j++) {
				curr = curr + arr[j];
				res = Math.max(curr, res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { -5, 1, -2, 3, -1, 2, -2 };
		System.out.println(maxSubArr(arr));
	}

}
