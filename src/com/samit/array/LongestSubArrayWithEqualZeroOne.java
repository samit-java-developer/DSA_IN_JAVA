package com.samit.array;

public class LongestSubArrayWithEqualZeroOne {

    public static void main(String[] args) {
        int[] arr={1,1,1,0,1,0};
        int x=sortNaive(arr,arr.length);
        System.out.println(x);
    }

    static int sortNaive(int[] arr,int n){
        int res=0;
        for (int i=0;i<n;i++){
            int c0=0,c1=0;
            for (int j = i; j <n ; j++) {
                if (arr[j]==1){
                    c1++;
                }else{
                    c0++;
                }
                if (c0==c1) res=Math.max(res,c0+c1);
            }
        }
        return res;
    }
}
