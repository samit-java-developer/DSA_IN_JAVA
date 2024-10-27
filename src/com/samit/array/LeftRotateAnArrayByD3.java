package com.samit.array;

import java.util.Arrays;

public class LeftRotateAnArrayByD3 {

	static void leftRotatae(int[] arr, int d) {
		reverseArr(arr, 0, d - 1);
		reverseArr(arr, d, arr.length - 1);
		reverseArr(arr, 0, arr.length - 1);
	}

	static void reverseArr(int[] arr, int low, int high) {
		while (low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[high];
		arr[high] = arr[low];
		arr[low] = temp;
	}

	public static void main(String[] args) {
		/*
		 * Theta(n*d) it means minimum it will take Theta(n*d) , Theta(1)
		 */
		int[] arr = { 1, 2, 3, 4, 5 };
		leftRotatae(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

}
