package com.samit.stack.practice;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestRectangularArea {
    public static void main(String[] args) {
        int[] arr={6,2,5,4,1,5,6};
        int xx=getMaxAreaNaive(arr,arr.length);
        System.out.println(xx);
        //int[] previousSmaller=previousSmaller(arr,arr.length);
        //System.out.println(Arrays.toString(previousSmaller));
        //int[] nextSmaller=nextSmaller(arr,arr.length);
        //System.out.println(Arrays.toString(nextSmaller));
        int res=getMaxAreaEfficient(arr,arr.length);
        System.out.print(res);
    }

    static int getMaxAreaNaive(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) curr += arr[i];
                else break;
            }
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) curr += arr[i];
                else break;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    static int getMaxAreaEfficient(int[] arr,int n){
        int[] previousSmaller=previousSmaller(arr,n);
        int[] nextSmaller=nextSmaller(arr,n);
        int res=0;
        for (int i=0;i<n;i++){
            int curr=arr[i];
            curr+=(i-previousSmaller[i]-1)*arr[i];
            curr+=(nextSmaller[i]-i-1)*arr[i];
            res=Math.max(res,curr);
        }
        return res;
    }

    static int[] previousSmaller(int[] arr,int n){
        int[] res=new int[n];
        res[0]=-1;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        for (int i=1;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }

    static int[] nextSmaller(int[] arr,int n){
        int[] res=new int[n];
        res[n-1]=n;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(n-1);
        for (int i=n-2;i>=0;i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return res;
    }

    static void reverse(int[] arr,int n){
        int i=0;
        int j=n-1;
        while (i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
