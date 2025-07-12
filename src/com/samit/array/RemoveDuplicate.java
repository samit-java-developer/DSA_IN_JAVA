package com.samit.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicate {

	static int[] removeDuplicate(int[] arr, int n) {
		List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int j = i + 1;
			result.add(arr[i]);
			while (j < n && temp == arr[j]) {
				j++;
			}
			i = j - 1;
		}
		//return result.stream().mapToInt(ele -> ele).filter(x -> x % 2 == 0).toArray();
		return result.stream().mapToInt(ele -> ele).toArray();
	}
	static void removeDuplicate(int[] arr){
		int temp=arr[0];
		System.out.print(temp+" ");
		for (int i=1;i<arr.length;i++){
			if (arr[i]==temp){
				continue;
			}
			temp=arr[i];
			System.out.print(temp+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 10, 22, 22, 33 };
		int[] res = removeDuplicate(arr, 5);
		System.out.println();
		System.out.println(Arrays.toString(res));
		removeDuplicate(arr);
	}

}
