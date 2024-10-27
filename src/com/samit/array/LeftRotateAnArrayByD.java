package com.samit.array;

import java.util.Arrays;

public class LeftRotateAnArrayByD {

	static void leftRotataeOne(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}

	static void leftRotatae(int[] arr, int d) {
		for (int i = 0; i < d; i++) {
			leftRotataeOne(arr);
		}
	}

	public static void main(String[] args) {
		/*
		 *  Theta(n*d) it means minimum it will take Theta(n*d) , Theta(1)
		 */		int[] arr= {1,2,3,4,5};
		leftRotatae(arr,2);
		System.out.println(Arrays.toString(arr));
	}

}
