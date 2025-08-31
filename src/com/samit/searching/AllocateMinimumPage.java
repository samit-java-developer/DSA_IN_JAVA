package com.samit.searching;

public class AllocateMinimumPage {
    static int allocate(int[] arr,int n,int k){
        if (k==1){
            return getSum(arr,0,n-1);
        }
        if (n==1){
            return arr[0];
        }
        int res=Integer.MAX_VALUE;
        int sum=0;
        for (int i=1;i<n-2;i++){
            sum+=arr[i];
            res=Math.min(res,Math.max(allocate(arr,i,k-1),sum));
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
        int res=allocate(arr,arr.length,k);
        System.out.println(res);
    }
}
