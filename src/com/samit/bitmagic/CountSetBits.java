package com.samit.bitmagic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSetBits {
	public static void main(String[] args) {
		int n = 100;
		int count = 0;
		List<Integer> res=new ArrayList<Integer>();
		while (n != 0) {
			if ((n & 1) != 0) {
				res.add(1);
				count += 1;
			}else{
				res.add(0);
			}
			n = n >> 1;
		}
		String resss=res.stream().map(x->x+"").collect(Collectors.joining(" "));
		resss=IntStream.range(0,res.size()).mapToObj(i->res.get(res.size()-1-i)).map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(resss);
	}
}
