package com.samit.string;

class Solution {
    public String reverseWords(String s) {
        // Code here
        String[] strArr = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        String[] finalArr = reverse(strArr);
        int n = finalArr.length;
        for (int i = 0; i < n; i++) {
            sb.append(finalArr[i]);
            if (i != n - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public String[] reverse(String[] input) {
        int low = 0;
        int high = input.length - 1;
        while (low < high) {
            String temp = input[low];
            input[low] = input[high];
            input[high] = temp;
            low++;
            high--;
        }
        return input;
    }
}
