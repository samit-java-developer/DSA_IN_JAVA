package com.samit.bitmagic;

public class CountSetBitsEfficient {
	public static void main(String[] args) {
		int n = 1000000;
		int count = 0;
		while (n != 0) {
			count++;
			n = n & n - 1;
		}
		System.out.println(count);
	}
}
