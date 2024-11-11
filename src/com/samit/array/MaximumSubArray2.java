package com.samit.array;

public class MaximumSubArray2 {

	static int maxSubArr(int[] arr) {
		int res = arr[0];
		int maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding=Math.max(maxEnding+arr[i], arr[i]);
			res=Math.max(maxEnding, res);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { -5, 1, -2, 3, -1, 2, -2 };
		System.out.println(maxSubArr(arr));
	}

}
