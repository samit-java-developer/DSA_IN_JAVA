package com.samit.recursion;

public class Palindrome {

	static boolean isPalindrome(String str, int start, int end) {
		if (start >= end) {
			return true;
		}
		return (str.charAt(start) == str.charAt(end)) && isPalindrome(str, start + 1, end - 1);
	}

	public static void main(String[] args) {
		String str = "abcba";
		System.out.println(isPalindrome(str, 0, str.length() - 1));
	}
}
