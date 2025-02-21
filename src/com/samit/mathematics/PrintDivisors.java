package com.samit.mathematics;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintDivisors {

	static Set<Integer> divisors = new TreeSet<Integer>();
	static Set<Integer> divisors2 = new LinkedHashSet<Integer>();

	// using TreeSet
	static void printDivisors(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				divisors.add(i);
				if (i != n / i) {
					divisors.add(n / i);
				}
			}
		}
	}

	// without TreeSet
	static void printDivisorSecondWay(int n) {
		int i;
		for (i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				divisors2.add(i);
			}
		}
		for (; i >= 1; i--) {
			if (n % i == 0) {
				divisors2.add(n / i);
			}
		}
	}

	static void printAllDivisors(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if ((n / i) == i) {
					System.out.print(i + "");
				} else {
					System.out.print(i + " ");
					System.out.print(n / i + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		printDivisors(10);
		System.out.println(divisors.toString());

		System.out.println("-----------------------\n");
		printDivisorSecondWay(100);
		System.out.println(divisors2.toString());
		System.out.println("-----------------------\n");
		printAllDivisors(188);

	}

}
