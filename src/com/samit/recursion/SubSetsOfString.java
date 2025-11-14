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

	static void subSet2(String s, String curr,int i) {
		if (i == s.length()) {
			System.out.println(curr);
			return;
		}
		char ch = s.charAt(i);
		subSet2(s, curr + ch, i + 1);
		subSet2(s, curr , i + 1);
	}

	public static void main(String[] args) {
		String s = "ABCD";
		Set<String> sets=new HashSet<String>();
		subSet(s, "", 0);
	}

	static void subSet(String input,String curr,int i){
		if (i==input.length()){
			System.out.print(curr+" ");
			return;
		}
		char ch=input.charAt(i);
		subSet(input,curr+ch,i+1);
		subSet(input,curr,i+1);
	}
}
