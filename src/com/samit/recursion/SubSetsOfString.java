package com.samit.recursion;

import java.util.HashSet;
import java.util.Set;

public class SubSetsOfString {

	static void subSet(String s, String curr, int i, Set<String> sets) {
		if (i == s.length()) {
			sets.add(curr);
			return;
		}
		char ch = s.charAt(i);
		subSet(s, curr, i + 1,sets);
		subSet(s, curr + ch, i + 1,sets);
	}

	public static void main(String[] args) {
		String s = "ABCD";
		Set<String> sets=new HashSet<String>();
		subSet(s, "", 0,sets);
		System.out.println(sets);
	}

}
