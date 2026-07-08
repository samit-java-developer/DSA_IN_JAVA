package com.samit.bitmagic;

public class CountSetBitsEfficient {

	static int[] bitSetTable256=new int[256];
	public static void main(String[] args) {
//		int n = 1000000;
//		int count = 0;
//		while (n != 0) {
//			count++;
//			n = n & n - 1;
//		}
//		System.out.println(count);

		int n=256;
		initialize();
		int xx=countSetBits(n);
		System.out.println(xx);
	}

	public static void initialize(){
		bitSetTable256[0]=0;
		for(int i=0;i<256;i++){
			bitSetTable256[i]=(i&1) +bitSetTable256[i/2];
		}
	}

	public static int countSetBits(int n){
		return (bitSetTable256[n& 0xff]+bitSetTable256[(n>>8 & 0xff)]+bitSetTable256[(n>>16 & 0xff)]+bitSetTable256[(n>>24)]);
	}
}
