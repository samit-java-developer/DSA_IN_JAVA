package com.samit.mathematics;

public class Lcm {
	public static void main(String[] args) {
		int a = 6;
		int b = 9;
		int start = Math.max(a, b);
		int end = a * b;
		for (int i = start; i <= end; i++) {
			if (i % a == 0 && i % b == 0) {
				System.out.println("Common factor :: " + i);
				break;
			}
		}
	}
}
