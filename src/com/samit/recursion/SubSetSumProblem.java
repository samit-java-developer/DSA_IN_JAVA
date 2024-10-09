package com.samit.recursion;

public class SubSetSumProblem {
	static int countSubSet(int[] arr, int sum, int i) {
		if (i == arr.length) {
			if (sum == 0) {
				return 1;
			}
			return 0;
		}
		int current = arr[i];
		return countSubSet(arr, sum, i + 1) + countSubSet(arr, sum - current, i + 1);
	}


	public static void main(String[] args) {
		int[] arr = {2,4,6};
		System.out.println(countSubSet(arr, 6, 0));
	}
}
