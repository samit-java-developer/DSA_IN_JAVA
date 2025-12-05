package com.samit.searching;

public class AllocateMinimumPage {
    static int allocate(int[] arr,int start,int end, int k){
        if (k==1) return getSum(arr,start,end);
        if (start==end) return arr[start];
        int res=Integer.MAX_VALUE;
        int sum=0;
        for (int i=start;i<end;i++){
            sum+=arr[i];
            res=Math.min(res,Math.max(allocate(arr,i+1,end,k-1),sum));
        }
        return res;
    }

    static int getSum(int[] arr,int start,int end){
        int sum=0;
        for (int i=start;i<=end;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40};
        int k=2;
        int res=allocate(arr,0,arr.length-1,k);
        System.out.println(res);
    }
}
