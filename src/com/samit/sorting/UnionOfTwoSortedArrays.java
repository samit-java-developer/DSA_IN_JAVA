package com.samit.sorting;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a={10,20,20};
        int[] b={5,20,20,40};
        System.out.println();
        unionOfTwoSortedArr(a,b);
        System.out.println();
        unionOfTwoSortedArrEfficient(a,b);
        System.out.println();
    }

    static void unionOfTwoSortedArr(int[] a,int[] b){
        int m=a.length;
        int n=b.length;
        int[] c=new int[m+n];
        System.arraycopy(a, 0, c, 0, m);
        //(Object src,  int  srcPos,
        // Object destination, int destination-Pos,
        // int length)
        System.arraycopy(b, 0, c, m, n);
        Arrays.sort(c);
        for (int i=0;i<m+n;i++){
            if (i==0 || c[i]!=c[i-1]){
                System.out.print(c[i]+" ");
            }
        }
    }
    static void unionOfTwoSortedArrEfficient(int[] a,int[] b) {
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }
        while (i < m) {
            if (i > 0 && (a[i] != a[i - 1])) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
        while (j < n) {
            if (j >0 && (b[j] != b[j - 1])) {
                System.out.print(b[j] + " ");
            }
            j++;
        }
    }
}
