package com.samit.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumAppearingElementInRange {
    public static void main(String[] args) {
        int[] left={1,2,5,15};
        int[] right={5,8,7,18};
        Map<Integer,Integer> freqMap=new HashMap<>();
        for (int i=0;i<left.length;i++){
            for (int j=left[i];j<=right[i];j++){
                if (freqMap.containsKey(j)){
                    freqMap.put(j,freqMap.get(j)+1);
                }else{
                    freqMap.put(j,1);
                }
            }
        }
        int xx= freqMap.entrySet()
                .stream().min((a, b) -> b.getValue() - a.getValue()).get().getKey();
        System.out.println(xx);
        xx=freqMap.entrySet()
                .stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .findFirst().get().getKey();
        System.out.println(xx);
        int res=maxAppearEle(left,right);
        System.out.println(res);

    }
    static int maxAppearEle(int[] left,int[] right){
        int leftMax=Arrays.stream(left).mapToObj(e->(int)e).max((a,b)->a-b).get();
        int rightMax=Arrays.stream(right).mapToObj(e->(int)e).max((a,b)->a-b).get();
        int[] freq=new int[Math.max(leftMax,rightMax)+2];
        for(int i=0;i<left.length;i++){
            freq[left[i]]++;
            freq[right[i]+1]--;
        }
        for (int i=1;i<freq.length;i++){
            freq[i]=freq[i]+freq[i-1];
        }
        int max=Integer.MIN_VALUE;
        int frequ=Integer.MIN_VALUE;
        for (int i=0;i<freq.length;i++){
            if (frequ<freq[i]){
                frequ=freq[i];
                max=Math.max(max,i);
            }
        }
        return max;
    }

}
