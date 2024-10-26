package com.samit.array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

	static int getSecondLargest(int[] arr) {
		int firstMax = arr[0];
		int secondMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > firstMax) {
				secondMax = firstMax;
				firstMax = arr[i];
			}else if (firstMax>arr[i] && secondMax<arr[i]) {
				secondMax=arr[i];
			}
		}
		return secondMax;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 35, 1, 10, 34, 1 };
		/*
		 * Integer[] arrInteger=Arrays.stream(arr).boxed().toArray(Integer[]::new);
		 * Arrays.sort(arrInteger,new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return o2-o1; } });
		 * arr=Arrays.stream(arrInteger).mapToInt(Integer::intValue).toArray();
		 */

		System.out.println(getSecondLargest(arr));
		System.out.println(Arrays.toString(arr));
	}

}
