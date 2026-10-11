package com.samit.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateNumberWithGIvenDigit {

    static void printFirstN(int n){
        Queue<String> queue=new ArrayDeque<>();
        queue.add(5+"");
        queue.add(6+"");
        for (int count=0;count<n;count++){
            String xx=queue.poll();
            System.out.print(xx+" ");
            queue.add(xx+5);
            queue.add(xx+6);
        }
    }
    public static void main(String[] args) {
        printFirstN(10);
    }
}
