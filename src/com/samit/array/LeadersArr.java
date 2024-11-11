package com.samit.array;

public class LeadersArr {

	static void leaders(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			int ele = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (ele > arr[j]) {
					continue;
				} else if (ele <= arr[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 10, 6, 5, 2 };
		leaders(arr);
	}

}
