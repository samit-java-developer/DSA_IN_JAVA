package com.samit.sorting;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a={1,20,20,40,60};
        int[] b={2,20,20,20};
        intersectionOfAndB(a,b);
        System.out.println();
        intersectionEfficient(a,b);
    }

    static void intersectionOfAndB(int[] a,int[] b){
//        for (int i = 0; i < a.length; i++) {
//            if (i>0 && a[i]==a[i-1]){
//                i++;
//                continue;
//            }
//            for (int j=0;j<b.length;j++){
//                if (a[i]==b[j]){
//                    System.out.print(a[i]+" ");
//                    break;
//                }
//            }
//        }
        int i=0,j=0;
        while (i<a.length && j<b.length){
            if (i>0 && a[i]==a[i-1]){
                i++;
                continue;
            }
            if (a[i]<b[j]){
                i++;
            } else if (a[i]>b[j]) {
                j++;
            }else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }
    }


    static void intersectionEfficient(int[] a,int[] b){
        int i=0;
        int j=0;
        int m=a.length;
        int n=b.length;
        while (i<m && j<n){
            if (i>0 && a[i]==a[i-1]){
                i++;
                continue;
            }
            if (a[i]==b[j]){
                System.out.print(a[i]+" ");
                i++;
                j++;
            }else if (a[i]<b[j]){
                i++;
            }else{
                j++;
            }
        }
    }
    static void intersection(int[] a,int[] b){
        int m=a.length;
        int n=b.length;
        for (int i=0;i<m;i++){
            if (i>0 && a[i]==a[i-1]){
                continue;
            }
            for (int j=0;j<n;j++){
                if (a[i]==b[j]){
                    System.out.print(a[i]+" ");
                    break;
                }
            }
        }
    }
}
