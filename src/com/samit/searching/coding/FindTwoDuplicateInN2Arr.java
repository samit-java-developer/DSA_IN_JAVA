package com.samit.searching.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTwoDuplicateInN2Arr {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,3};
        int[] res=findRepeated(arr);
        System.out.println(Arrays.toString(res));
//        int first=findRepeated(arr,-1);
//        int second=findRepeated(arr,first);
//        System.out.println(first);
//        System.out.println(second);
//        int firstCount=0;
//        int secondCount=0;
//        List<Integer> res=new ArrayList<Integer>();
//        for (int x:arr){
//            if (x==first) firstCount++;
//            if (x==second) secondCount++;
//            if (firstCount==2){
//                res.add(first);
//                res.add(second);
//                break;
//            }
//            if (secondCount==2){
//                res.add(second);
//                res.add(first);
//                break;
//            }
//        }
//        res.forEach(System.out::println);
    }
    static int findRepeated(int[] arr,int ignore){
        int start=1;
        int end=arr.length-2;
        int ans=-1;
        while (start<=end){
            int mid=(start+end)/2;
            int count=0;
            for (int x:arr){
                if (x!=ignore && x<=mid){
                    count++;
                }
            }
            if (count>mid){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }

    static int[] findRepeated(int[] arr){
        int n=arr.length-2;
        long sumArr=0,sumSqArr=0;
        for (int x: arr){
            sumArr+=x;
            sumSqArr+= (long) x * x;
        }
        long sumNatural=(long)n*(n+1)/2;
        long sumSqNatural=(long)n*(n+1)*(2L * n+1)/6;
        long S=sumArr-sumNatural;  // x+y
        long Sq=sumSqArr-sumSqNatural;  // x^2+y^2
        long p=(S*S-Sq)/2;
        // Solve quadratic t^2 - S*t + P = 0

        long d=(long)Math.sqrt(S*S-4*p);
        int x=(int)((S-d)/2);
        int y=(int)((S+d)/2);

        int countX=0,countY=0;
        List<Integer> res=new ArrayList<Integer>();
        for (int num:arr){
            if (num==x) countX++;
            if (num==y) countY++;
            if (countX==2) {
                res.add(x);
                res.add(y);
                break;
            }
            if (countY==2){
                res.add(y);
                res.add(x);
                break;
            }
        }
        int[] ccc = res.stream().mapToInt(ele -> ele).toArray();
        return ccc;
    }
}

