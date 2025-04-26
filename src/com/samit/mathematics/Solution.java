package com.samit.mathematics;

class Solution {

	static int findTheDivisor(int k) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(k); i++) {
			if (k % i == 0) {
				if (k / i == i) {
					count += 1;
				} else {
					count += 2;
				}
			}
		}
		return count;
	}

	public int exactly3Divisors(int N) {
		int exactlyThree = 0;
		for (int i = 1; i <= N; i++) {
			System.out.println(i + "-->" + findTheDivisor(i));
			if (findTheDivisor(i) == 3) {
				exactlyThree++;
			}
		}
		return exactlyThree;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.exactly3Divisors(6));
	}
}