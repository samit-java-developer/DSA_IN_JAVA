package com.samit.mathematics;

public class GCD {
	
	static int gcdNavieApproach(int a,int b){
		int res=Math.min(a, b);
		while (res>0) {
			if (a%res==0 && b%res==0) {
				break;
			}
			res--;
		}
		return res;
	}
	
	static int gcdEuclid(int a,int b){
		while (a!=b) {
			if (a>b) {
				a=a-b;
			}else {
				b=b-a;
			}
		}
		return a;
	}
	static int gcdEfficientEuclid(int a,int b){
		if (b==0) {
			return a;
		}else {
			return gcdEfficientEuclid(b, a%b);
		}
	}

	public static void main(String[] args) {
		System.out.println(gcdEfficientEuclid(10, 20));
	}

}
