package com.samit.recursion;

import java.util.ArrayList;
import java.util.List;


public class SubSetSumProblem {
	static int countSubSet(int[] arr, int sum, int i) {
		if (i == arr.length) {
			if (sum == 0) {
				return 1;
			}
			return 0;
		}
		int current = arr[i];
		return countSubSet(arr, sum, i + 1) + countSubSet(arr, sum - current, i + 1);
	}

	public static void main(String[] args) {
		int[] arr = {2,4,6};
		//System.out.println(countSubSet(arr, 6, 0));
		List<List<Integer>> set=new ArrayList<>();
		printSubSet(arr,0,set, new ArrayList<Integer>());
		System.out.println(set);
	}

	static void printSubSet(int[] arr, int i, List<List<Integer>> set, List<Integer> subset) {
		if (i == arr.length) {
			set.add(new ArrayList<>(subset));
			return;
		}
		subset.add(arr[i]);
		printSubSet(arr, i + 1, set, subset);
		subset.remove(subset.size() - 1);
		printSubSet(arr, i+1, set, subset);
	}

}
