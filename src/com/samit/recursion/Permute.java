package com.samit.recursion;

public class Permute {

	static void permute(char[] s, int i) {
		if (i == s.length - 1) {
			System.out.println(s);
			return;
		}
		for (int j = i; j < s.length; j++) {
			System.out.println("swapping the element i and j (" + i + " " + j + ")");
			swap(s, i, j);
			permute(s, i + 1);
			swap(s, j, i);
		}
	}

	static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void main(String[] args) {
		char[] ch = { 'A', 'B', 'C' };
		permute(ch, 0);
	}

}
