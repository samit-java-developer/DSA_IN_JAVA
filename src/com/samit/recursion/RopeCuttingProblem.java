package com.samit.recursion;

public class RopeCuttingProblem {

	static int maxCut(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		int res;
		int x = maxCut(n - a, a, b, c);
		int y = maxCut(n - b, a, b, c);
		int z = maxCut(n - c, a, b, c);
		res = x > y ? x : y;
		res = res > z ? res : z;
		if (res == -1) {
			return -1;
		}
		return res + 1;
	}

	public static void main(String[] args) {
		int n = 19;
		System.out.println(maxCut(n, 2, 1, 3));

	}

}
