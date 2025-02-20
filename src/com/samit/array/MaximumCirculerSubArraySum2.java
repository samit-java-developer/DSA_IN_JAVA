package com.samit.array;

public class MaximumCirculerSubArraySum2 {

	static int normalMaxSum(int[] arr) {
		int res = arr[0], maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding = Math.max(arr[i], maxEnding + arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}

	//theta(n)
	static int overAllMaxSum(int[] arr) {
		int max_normal = normalMaxSum(arr);
		int arr_sum = 0;
		if (max_normal < 0) {
			return max_normal;
		}
		for (int i = 0; i < arr.length; i++) {
			arr_sum += arr[i];
			arr[i] = -arr[i];
		}
		int max_circuler = arr_sum + normalMaxSum(arr);
		return Math.max(max_normal, max_circuler);
	}

	public static void main(String[] args) {
		int[] arr = { -5, -3 };
		System.out.println(overAllMaxSum(arr));
	}

}
