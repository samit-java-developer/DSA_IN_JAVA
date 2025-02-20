package com.samit.java8.chatgpt.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateElemntsInList {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 8, 6, 5, 4, 3, 2, 1 };
		List<Integer> distinctEle = Arrays.stream(numbers).boxed()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());

		System.out.println(distinctEle);

	}

}
