package com.samit.array;

import java.util.Arrays;

public class MoveZerosToEnd {

	private static void moveToEnd(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						swap(arr, i, j);
						break;
					}
				}
			}
		}
	}

	private static void moveToEndEfficient(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				swap(arr, i, count);
				count++;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 3, 0, 34, 88 };
		moveToEndEfficient(arr);
		System.out.println(Arrays.toString(arr));
	}

}
