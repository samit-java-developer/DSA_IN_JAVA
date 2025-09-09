package com.samit.sorting;

public class CountInversionInArr {

    public static void main(String[] args) {
       // int[] arr={2,4,1,3,5};
        int[] arr={40,30,20,10};
        int x=countInversionInArr(arr);
        System.out.println(x);
        x=countInversion(arr,0,arr.length-1);
        System.out.println(x);
    }

    static int countInversionInArr(int[] arr){
        int n=arr.length;
        int count=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    static int countInversion(int[] arr,int l,int r){
        if (r>l){
            int m=l+(r-l)/2;
            int x=countInversion(arr,l,m);
            int y=countInversion(arr,m+1,r);
            int z=countAndMerge(arr,l,m,r);
            return x+y+z;
        }
        return 0;
    }

    static int countAndMerge(int [] arr,int l,int m, int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for (int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for (int i=0;i<n2;i++){
            right[i]=arr[m+1+i];
        }
        int k=l,i=0,j=0,res=0;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }else{
                arr[k]=right[j];
                j++;
                k++;
                res+=(n1-i);
            }
        }
        while (i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
        return res;
    }

}
