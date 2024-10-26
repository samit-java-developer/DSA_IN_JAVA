package com.samit.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicate {

	static int[] removeDuplicate(int[] arr, int n) {
		List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int j = i + 1;
			result.add(arr[i]);
			while (j < n && temp == arr[j]) {
				j++;
			}
			i = j - 1;
		}
		return result.stream().mapToInt(ele -> ele).filter(x -> x % 2 == 0).toArray();
	}

	public static void main(String[] args) {
		int[] arr = { 10, 10, 22, 22, 33 };
		int[] res = removeDuplicate(arr, 5);
		System.out.println(Arrays.toString(res));
	}

}
