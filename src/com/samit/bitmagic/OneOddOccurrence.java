package com.samit.bitmagic;

public class OneOddOccurrence{

    public static void main(String[] args) {
        int[] arr={7,3,7};
        int res=findOddViaNaive(arr,arr.length);
        System.out.println(res);
        res=findOneOddOccure(arr);
        System.out.println(res);
    }

    static int findOddViaNaive(int[] arr,int n){
        for (int i=0;i<n;i++){
            int count=0;
            for (int j=0;j<arr.length;j++){
                if (arr[i]==arr[j]){
                    count++;
                }
            }
            if (count%2!=0){
                return arr[i];            }
        }
        return -1;
    }

    static int findOneOddOccure(int[] arr){
        int res=arr[0];
        for (int i=1;i<arr.length;i++){
            res=res^arr[i];
        }
        return res;
    }
}
