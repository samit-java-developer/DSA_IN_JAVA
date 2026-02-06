package com.samit.stack;

import java.util.ArrayDeque;

public class LargestRectangleWithAllOnes {

    public static void main(String[] args) {
        int[][] arr={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int x=getLargestRectangle(arr);
        System.out.println(x);
    }

    static int getLargestRectangle(int[][] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (i>0){
                    if (arr[i][j]==1){
                        arr[i][j]+=arr[i-1][j];
                    }
                }
            }
            res=Math.max(res,getMaxAreaMoreEfficient(arr[i]));
        }
        return res;
    }

    static int getMaxAreaMoreEfficient(int[] arr) {
        int n = arr.length;
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int curr = 0;
        int tp = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                tp = stack.pop();
                curr = arr[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                res = Math.max(res, curr);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            tp = stack.pop();
            curr = arr[tp] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
    }
}
