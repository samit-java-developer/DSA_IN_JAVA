package com.samit.java8.chatgpt.array;

import java.util.Arrays;
import java.util.Optional;

public class ArrayRelated {

	public static void main(String[] args) {

		int[] numbers = { 10, 5, 8, 20, 15, 20, 8 };
		// Optional<Integer> opInt = Arrays.stream(numbers).mapToObj(e -> (int)
		// e).sorted((a, b) -> a - b).distinct()
		// .skip(1).findFirst();

		// same above line can be written via this below mentioned way...
		Optional<Integer> opInt = Arrays.stream(numbers).boxed().sorted((a, b) -> b - a).distinct().skip(1).findFirst();
		if (opInt.isPresent()) {
			System.out.println(opInt.get());
		}

	}

}
