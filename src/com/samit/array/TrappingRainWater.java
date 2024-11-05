package com.samit.array;

public class TrappingRainWater {

	static int getWater(int[] arr) {
		int res = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int lMax = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				lMax = Math.max(lMax, arr[j]);
			}
			int rMax = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				rMax = Math.max(rMax, arr[j]);
			}
			res += (Math.min(lMax, rMax)) - arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1, 2, 5 };
		System.out.println(getWater(arr));
	}

}
