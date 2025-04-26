package com.samit.bitmagic;

import java.util.Arrays;

public class CountSetBitsTable {
	public static void main(String[] args) {
		int n = 10;
		int[] table = new int[256];
		table[0] = 0;
		for (int i = 1; i < 256; i++) {
			table[i] = table[i & (i - 1)] + 1;
		}
		System.out.println(Arrays.toString(table));
		int setBits = table[n & 255] + table[n >> 8 & 255] + table[n >> 16 & 255] + table[(n >> 24)];
		System.out.println(setBits);
	}
}
