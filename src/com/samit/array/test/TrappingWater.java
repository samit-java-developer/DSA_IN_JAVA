package com.samit.array.test;

public class TrappingWater {

    public static void main(String[] args) {
        int[] height = {3,0,1,2,5};
        int res=trap(height);
        System.out.println(res);
        res=trapEfficient(height);
        System.out.println(res);
    }

    static int trap(int[] height) {
        int n = height.length;
        int result = 0;
        for (int i=1; i<n-1; i++) {
            int rMax = height[i+1];
            for (int j=i+2; j<n; j++) {
                if(rMax<height[j]) {
                    rMax = height[j];
                }
            }
            int lMax=height[i-1];
            for (int j=i-2; j>=0; j--) {
                if(lMax<height[j]) {
                    lMax = height[j];
                }
            }
            result+=Math.min(lMax,rMax)-height[i];
        }
        return result;
    }

    static int trapEfficient(int[] height) {
        int n = height.length;
        int result = 0;
        int[] lMax = new int[n];
        lMax[0] = height[0];
        int[] rMax = new int[n];
        rMax[n-1] = height[n-1];
        for (int i=1; i<n; i++) {
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        for (int i=n-2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1],height[i]);
        }
        for(int i=1; i<n-1; i++) {
            result+=Math.min(lMax[i],rMax[i])-height[i];
        }
        return result;
    }
}
