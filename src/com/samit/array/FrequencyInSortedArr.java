package com.samit.array;

public class FrequencyInSortedArr {

	static void frequencyInSortedArr(int[] arr) {
		int j = 0;
		int count;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			count = 1;
			j = i + 1;
			while (j<arr.length && temp == arr[j]) {
				count++;
				j=j+1;
			}
			System.out.println(arr[i] + "--: " + count);
			i = i + count - 1;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 10, 10, 20, 20, 20, 30, 40,40 };
		frequencyInSortedArr(arr);
	}
}
