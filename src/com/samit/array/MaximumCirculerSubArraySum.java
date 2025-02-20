package com.samit.array;

public class MaximumCirculerSubArraySum {

	static int maxCirculerSum(int[] arr) {
		int res = 0;
		int index;
		int curr_max;
		int curr_sum;
		for (int i = 0; i < arr.length; i++) {
			curr_max = arr[i];
			curr_sum = arr[i];
			for (int j = 1; j < arr.length; j++) {
				index = (i + j) % arr.length;
				curr_sum += arr[index];
				curr_max = Math.max(curr_max, curr_sum);
			}
			res = Math.max(curr_max, res);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, -2, 3, 4 };
		System.out.println(maxCirculerSum(arr));
	}

}
