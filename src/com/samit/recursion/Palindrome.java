package com.samit.recursion;

public class Palindrome {

	//static boolean isPalindrome(String str, int start, int end) {
	//	if (start >= end) {
	//		return true;
	//	}
	//	return (str.charAt(start) == str.charAt(end)) && isPalindrome(str, start + 1, end - 1);
	//}

//	static boolean isPalindrome(String str,int start, int end) {
//		if (start >= end) {
//			return true;
//		}
//		return (str.charAt(start)==str.charAt(end)) && (isPalindrome(str, start+1, end-1));
//	}

	static boolean isPalinDrome(String input,int low,int high){
		if (low>=high){
			return true;
		}
		return input.charAt(low)==input.charAt(high) && isPalinDrome(input,low+1,high-1);
	}

	static int sumOfDigit(int n){
		if (n==0){
			return 0;
		}
		return sumOfDigit(n/10)+n%10;
	}
	public static void main(String[] args) {
		String str = "abbb";
		System.out.println(isPalinDrome(str, 0, str.length() - 1));
		int x=sumOfDigit(123);
		System.out.println(x);
	}
}
