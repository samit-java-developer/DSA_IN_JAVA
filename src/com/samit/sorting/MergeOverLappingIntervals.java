package com.samit.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverLappingIntervals {

    static class Interval{
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Interval[] arr=new Interval[4];
        Interval i1=new Interval(5,10);
        Interval i2=new Interval(3,15);
        Interval i3=new Interval(18,30);
        Interval i4=new Interval(2,7);
        arr[0]=i1;
        arr[1]=i2;
        arr[2]=i3;
        arr[3]=i4;
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        Interval[] result=mergedInterval(arr,arr.length);
        Arrays.stream(result).forEach(System.out::println);

        int[][] arr2D=new int[3][2];
        arr2D[0][0]=5;
        arr2D[0][1]=10;

        arr2D[1][0]=3;
        arr2D[1][1]=15;

        arr2D[2][0]=18;
        arr2D[2][1]=30;

        arr2D[3][0]=2;
        arr2D[3][1]=7;

        Arrays.sort(arr2D,(o1,o2)->o1[0]-o2[0]);
    }

    static Interval[] mergedInterval(Interval[] arr,int n){

//        Comparator<Interval> comp=new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start-o2.start;
//            }
//        };
        Arrays.sort(arr,(o1,o2)->o1.start-o2.start);
        int res=0;
        for (int i=1;i<n;i++){
            if (arr[res].end>=arr[i].start){
                arr[res].start=Math.min(arr[res].start,arr[i].start);
                arr[res].end=Math.max(arr[res].end,arr[i].end);
            }else{
                res++;
                arr[res]=arr[i];
            }
        }
        Interval[] result=new Interval[res+1];
        for (int i=0;i<result.length;i++){
            result[i]=arr[i];
        }
        return result;
    }

}
