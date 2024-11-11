package com.samit.array;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyInSortedArr2 {

	static void frequencyInSortedArr(int[] arr) {
		int count = 1;
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
				count++;
			} else {
				map.put(arr[i], count);
				count = 1;
			}
		}
		List<Integer> freL = map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
		System.out.println(freL);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 10, 10, 20, 20, 20, 30, 40, 40 };
		frequencyInSortedArr(arr);
	}
}
