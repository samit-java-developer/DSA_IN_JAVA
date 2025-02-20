package com.samit.java8.chatgpt.stream;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String s1 = "aabbcddefg";
		Character firstNonRepeating = s1.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(e -> e.getKey()).findFirst()
				.orElse(null);

		System.out.println(firstNonRepeating);

	}

}
