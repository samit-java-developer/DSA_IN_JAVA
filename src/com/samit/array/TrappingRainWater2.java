package com.samit.array;

public class TrappingRainWater2 {

	static int getWater(int[] arr) {
		int[] lMax = new int[arr.length];
		int[] rMax = new int[arr.length];

		lMax[0] = arr[0];
		rMax[arr.length - 1] = arr[arr.length - 1];

		for (int i = 1; i < arr.length; i++) {
			lMax[i] = Math.max(lMax[i - 1], arr[i]);
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			rMax[i] = Math.max(rMax[i + 1], arr[i]);
		}

		int res = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			res += (Math.min(lMax[i], rMax[i])) - arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1, 2, 5 };
		System.out.println(getWater(arr));
	}

}
