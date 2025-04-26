package com.samit.bitmagic;

public class CountSetBits {
	public static void main(String[] args) {
		int n = 100;
		int count = 0;
		while (n != 0) {
			if ((n & 1) != 0) {
				count += 1;
			}
			n = n >> 1;
		}
		System.out.println(count);
	}
}
