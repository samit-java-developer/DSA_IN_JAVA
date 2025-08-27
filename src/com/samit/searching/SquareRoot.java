package com.samit.searching;

public class SquareRoot {
    public static void main(String[] args) {
        int res=squareRoot(111);
        System.out.println(res);
    }

    static int squareRoot(int n){
        int low=1;
        int high=n;
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int midSquare=mid*mid;
            if (midSquare==n){
                return mid;
            }else if (midSquare>n){
                high=mid-1;
            }else{
                low=mid+1;
                ans=mid;
            }
        }
        return ans;
    }
}
