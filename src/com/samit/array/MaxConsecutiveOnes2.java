package com.samit.array;

public class MaxConsecutiveOnes2 {

	static int maxConsecutiveOnes(int[] arr) {
		int res = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count = 0;
			} else {
				count++;
				res = Math.max(count, res);
			}
		}
		return res;
	}

	static int maxConsecutiveTwos(int[] arr) {
		int res = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 2) {
				count = 0;
			} else {
				count++;
				res = Math.max(count, res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 2, 3, 2, 2, 2 };
		System.out.println(maxConsecutiveTwos(arr));
	}

}
