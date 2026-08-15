package com.samit.sorting.practice;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={4,5,7,8,2,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        buildHeap(arr);
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapFy(arr, i, 0);
        }
    }

    static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapFy(arr, n, i);
        }
    }

    static void maxHeapFy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapFy(arr, n, largest);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

