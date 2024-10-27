package com.samit.array;

import java.util.Arrays;

public class LeftRotateAnArrayByD2 {

	static void leftRotatae(int[] arr, int d) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}
		for (int i = 0; i < d; i++) {
			arr[arr.length - d + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		/*
		 * theta(d+n-d+d)==(n+d)==theta(n)
		 */ 
		int[] arr = { 1, 2, 3, 4, 5 };
		leftRotatae(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

}
