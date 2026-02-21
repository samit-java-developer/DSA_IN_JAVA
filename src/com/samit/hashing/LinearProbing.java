package com.samit.hashing;

import java.util.ArrayList;

public class LinearProbing {

    public static ArrayList<Integer> linearProbing(int[] arr, int m) {
        ArrayList<Integer> output=new ArrayList<Integer>(m);
        for (int i=0;i<m;i++){
            output.add(-1);
        }
        int n=arr.length;
        for (int i=0;i<n;i++){
            int value=arr[i];
            int index=value%m;
            int startIndex=index;
            while (output.get(index)!=-1){
                if (output.get(index)==value){
                    break;
                }
                index=(index+1)%m;
                if (index==startIndex){
                    break;
                }
            }
            if (output.get(index)==-1){
                output.set(index,value);
            }
        }
        return output;
    }

    public static void main(String[] args) {

        int[] arr={4,14,24,44};
        int m=10;
        ArrayList<Integer> res=linearProbing(arr,m);
        System.out.println(res);
    }
}
