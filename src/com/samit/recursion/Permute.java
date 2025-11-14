package com.samit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

	static void permute(char[] s, int i) {
		if (i == s.length - 1) {
			System.out.println(s);
			return;
		}
		for (int j = i; j < s.length; j++) {
			System.out.println("swapping the element i and j (" + i + " " + j + ")");
			swap(s, i, j);
			permute(s, i + 1);
			swap(s, j, i);
		}
	}


	static void permutation(char[] input, int i, List<String> opt){
		if (i==input.length-1){
			opt.add(new String(input));
			return;
		}
		for (int j=i;j<input.length;j++){
			swap(input,i,j);
			permutation(input,i+1,opt);
			swap(input,j,i);
		}
	}
	static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void main(String[] args) {
		char[] ch = { 'A', 'B', 'C' };
		//permute(ch, 0);
		List<String> opt=new ArrayList<>();
		permutation(ch,0,opt);
		opt.forEach(System.out::println);
	}

}
