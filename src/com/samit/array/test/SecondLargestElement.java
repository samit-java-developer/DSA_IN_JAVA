package com.samit.array.test;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10,10,10};
        int res=findSecondLargest(arr);
        System.out.println(res);
        res=findFirstLargest(arr);
        System.out.println(res);
        res=findSecondLargestEfficient(arr);
        System.out.println(res);
    }
    static int findSecondLargest(int[] arr) {
        int largest = findFirstLargest(arr);
        int res=-1;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]!=arr[largest]) {
                if(res==-1){
                    res=i;
                }else if(arr[i]>arr[res]){
                    res=i;
                }
            }
        }
        return res;
    }

    static int findFirstLargest(int[] arr) {
        int largest = 0;
        for (int i = 1; i < arr.length; i++) {
            largest = arr[i] > arr[largest] ? i : largest;
        }
        return largest;
    }

    static int findSecondLargestEfficient(int[] arr) {
        int firstLargest = -1;
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>firstLargest){
                secondLargest = firstLargest;
                firstLargest = arr[i];
            }else if(arr[i]>secondLargest && arr[i]!=firstLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
