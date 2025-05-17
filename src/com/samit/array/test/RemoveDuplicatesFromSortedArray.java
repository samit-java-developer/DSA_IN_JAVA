package com.samit.array.test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2,3,3,4,4,4,5,6,6,6,7,8,9};
        int length=removeDuplicates(nums);
        for(int i=0;i<length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        int[] nums2 = { 1, 2, 2,3,3,4,4,4,5,6,6,6,7,8,9};
        length=removeDuplicatesEfficient(nums2);
        System.out.println(length);
        for(int i=0;i<length;i++){
            System.out.print(nums2[i]+" ");
        }
    }
    static int removeDuplicates(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            if (temp[res] != nums[i]) {
                temp[++res] = nums[i];
            }
        }
        for (int i = 0; i < res+1; i++) {
            nums[i]=temp[i];
        }
        return res+1;
    }
    static int removeDuplicatesEfficient(int[] nums) {
        int res=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res-1] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
