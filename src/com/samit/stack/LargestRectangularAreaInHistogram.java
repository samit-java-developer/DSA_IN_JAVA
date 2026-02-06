package com.samit.stack;

import java.util.ArrayDeque;

public class LargestRectangularAreaInHistogram {

    public static void main(String[] args) {
        int[] arr={6,2,5,4,1,5,6};
        System.out.println(getMaxArea(arr));
        System.out.println(getMaxAreaEfficient(arr));
        System.out.println(getMaxAreaMoreEfficient(arr));
    }

    static int getMaxArea(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            for (int j = i - 1; j >= 0 && arr[j] >= arr[i]; j--) {
                curr += arr[i];
            }
            for (int j = i + 1; j < n && arr[j] >= arr[i]; j++) {
                curr += arr[i];
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    static int getMaxAreaEfficient(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] ps = new int[n];
        int[] ns = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        ps[0] = -1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        ns[n - 1] = n;
        stack.clear();
        stack.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            curr += arr[i] * (i - ps[i] - 1);
            curr += arr[i] * (ns[i] - i - 1);
            res = Math.max(res, curr);
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
