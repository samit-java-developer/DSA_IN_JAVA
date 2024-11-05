package com.samit.array;

public class MaxConsecutiveOnes {

	static int maxConsecutiveOnes(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int leftOnes = 0;
			int rightOnes = 0;
			if (arr[i] == 1) {
				leftOnes = 1;
				int j = i + 1;
				while (j < arr.length && arr[j] == 1) {
					leftOnes = leftOnes + 1;
					j++;
				}
				j = i - 1;
				while (j >= 0 && arr[j] == 1) {
					rightOnes = rightOnes + 1;
					j--;
				}
			}
			res = Math.max(res, leftOnes + rightOnes);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 };
		System.out.println(maxConsecutiveOnes(arr));
	}

}
