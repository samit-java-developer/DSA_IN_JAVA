package com.samit.array.test;

import java.util.Arrays;

public class MaxIndexDiff {

	public static void main(String[] args) {
		int[] arr = { 4, 8, 10, 3, 2, 80, 30, 33, 1 };
		int res = maxIndexDiff(arr);
		System.out.println(res);
	}

	static int maxIndexDiff(int[] arr) {
		int max = 0;
		int[][] sortedArr = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			sortedArr[i][0] = arr[i];
			sortedArr[i][1] = i;
		}
		System.out.println(Arrays.toString(sortedArr));
		Arrays.sort(sortedArr, (a, b) -> Integer.compare(a[0], b[0]));
		System.out.println(Arrays.toString(sortedArr));
		int minValue = sortedArr[0][1];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, sortedArr[i][1] - minValue);
			if (sortedArr[i][1] < minValue) {
				minValue = sortedArr[i][1];
			}
		}
		return max;
	}
}
