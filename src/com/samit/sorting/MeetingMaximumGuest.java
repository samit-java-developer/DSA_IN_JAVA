package com.samit.sorting;

import java.util.Arrays;

public class MeetingMaximumGuest {

    public static void main(String[] args) {
        int[] arr={900,940,950,1100,1500,1800};
        int[] dept={910,1200,1120,1130,1900,20000};
        int res=maximumGuest(arr,dept);
        System.out.println(res);
    }
    static int maximumGuest(int[] arr,int[] dept){
        Arrays.sort(arr);
        Arrays.sort(dept);
        int n=arr.length;
        int res=1,curr=1,i=1,j=0;
        while (i<n && j<n){
            if (arr[i]<=dept[j]){
                curr++;
                i++;
            }else{
                curr--;
                j++;
            }
            res=Math.max(curr,res);
        }
        return res;
    }
}
