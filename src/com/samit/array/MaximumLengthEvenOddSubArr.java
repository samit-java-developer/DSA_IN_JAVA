package com.samit.array;

public class MaximumLengthEvenOddSubArr {

	static int maxLengthEvenOddSubArr(int[] arr) {
		int res = 1;
		int count = 1;
		boolean isCurrentEven = false;
		boolean isPreviousEven;
		if (arr[0] % 2 == 0) {
			isPreviousEven = true;
		} else {
			isPreviousEven = false;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				isCurrentEven = true;
			} else {
				isCurrentEven = false;
			}
			if (isPreviousEven) {
				if (!isCurrentEven) {
					count++;
					res = Math.max(count, res);
				}
			} else if (!isPreviousEven) {
				if (isCurrentEven) {
					count++;
					res = Math.max(count, res);
				}
			} else {
				count = 1;
			}
			isPreviousEven = isCurrentEven;
		}
		return res;
	}

	static int maxLengthEvenOddSubArrShort(int[] arr) {
		int res = 1;
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i - 1] % 2 == 0 && arr[i] % 2 != 0) || (arr[i - 1] % 2 != 0 && arr[i] % 2 == 0)) {
				count++;
				res = Math.max(count, res);
			} else {
				count = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 12, 14, 7, 8 };
		System.out.println(maxLengthEvenOddSubArrShort(arr));
	}
}
