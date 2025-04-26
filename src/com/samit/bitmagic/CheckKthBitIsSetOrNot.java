package com.samit.bitmagic;

public class CheckKthBitIsSetOrNot {

	public static void main(String[] args) {
		int x = 1;
		int k = 4;
		int n = 10;
		for (int i = 0; i < (k - 1); i++) {
			x = x * 2;
		}
		if ((n & x) != 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		x = 1;
		System.out.println("---------------------------");
		if ((n & (x << (k - 1))) != 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
