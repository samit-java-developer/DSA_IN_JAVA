package com.samit.sorting;

public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};
        int n=a.length;
        int m=b.length;
        int i=0;
        int j=0;
        while (i<n && j<m){
            if (a[i]<=b[j]){
                i++;
            }else if (a[i]>b[j]){
                int value=a[i];
                a[i]=b[j];
                b[j]=value;
                int key=b[j];
                boolean flag=false;
                int temp=j;
                while ((temp+1)<m && key>b[temp+1]){
                    b[temp]=b[temp+1];
                    temp++;
                    flag=true;
                }
                if (flag){
                    if (temp<m){
                        b[temp]=key;
                    }
                }else{
                    if ((temp+1)<m){
                        b[temp+1]=key;
                    }
                }
            }
        }
    }

}
