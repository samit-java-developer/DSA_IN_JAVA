package com.samit.searching;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={6,7,8,9};
        int median=findMedian(arr1,arr2);
        System.out.println(median);
        median=findMedianOfTwoArr(arr1,arr2);
        System.out.println(median);
    }

    static int findMedian(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int low=0;
        int high=n1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int i2= (n1+n2+1)/2- mid;
            int max1= mid==0?Integer.MIN_VALUE:arr1[mid -1];
            int max2=i2==0?Integer.MIN_VALUE:arr2[i2-1];
            int min1=mid==n1?Integer.MAX_VALUE:arr1[mid];
            int min2=i2==n2?Integer.MAX_VALUE:arr2[i2];
            if (max1<=min2 && max2<=min1){
                if ((n1+n2)%2==0){
                    return (int)(Math.max(max1,max2)+Math.min(min1,min2))/2;
                }else{
                    return (int)(Math.max(max1,max2));
                }
            }else{
                if (max1>min2){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return 0;
    }

    static int findMedianOfTwoArr(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int low=0;
        int high=n1;
        while (low<=high){
            int i1=low+(high-low)/2;
            int i2=(((n1+n2+1)/2)-i1);
            int max1=i1==0?Integer.MIN_VALUE:arr1[i1-1];
            int min1=i1==n1?Integer.MAX_VALUE:arr1[i1];
            int max2=i2==0?Integer.MIN_VALUE:arr2[i2-1];
            int min2=i2==n2?Integer.MAX_VALUE:arr2[i2];
            if (max1<=min2 && max2<=min1){
                //now we have divide the both array in equal part.....
                if ((n1+n2)%2==0){
                    int total=Math.max(max1,max2)+Math.min(min1,min2);
                    return (int)(total/2);
                }else{
                    return (int)(Math.max(max1,max2));
                }
            }else{
                if (max1>min2){
                    high=i1-1;
                }else{
                    low=i1+1;
                }
            }
        }
        return 0;
    }
}
