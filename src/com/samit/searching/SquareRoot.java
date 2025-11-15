package com.samit.searching;

public class SquareRoot {
    public static void main(String[] args) {
        int res=squareRoot(5);
        System.out.println(res);
        res=new SquareRoot.Solution().floorSqrt(5);
        System.out.println(res);
    }

    static class Solution {
        int floorSqrt(int n) {
            int low=1;
            int high=n;
            int ans=-1;
            while (low<=high){
                int mid=low+(high-low)/2;
                if (mid*mid==n){
                    return mid;
                }else if (mid*mid>n){
                    high=mid-1;
                }else{
                    low=mid+1;
                    ans=mid;
                }
            }
            return ans;
        }
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
