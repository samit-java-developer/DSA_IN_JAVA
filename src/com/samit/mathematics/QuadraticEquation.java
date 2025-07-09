package com.samit.mathematics;

import java.util.ArrayList;

public class QuadraticEquation {

    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        int temp=(int)(Math.pow(b,2)-4*a*c);
        int roots1=0,roots2=0;
        ArrayList<Integer> roots=new ArrayList<Integer>();
        if (temp<0){
            roots.add(-1);
        }else{
            roots1=(int)Math.floor((-1*b+Math.sqrt(temp))/(2*a));
            roots1=(int)Math.floor((-1*b-Math.sqrt(temp))/(2*a));
            roots.add(Math.max(roots1,roots2));
            roots.add(Math.min(roots1,roots2));
        }
        return roots;
    }

    public static void main(String[] args) {
        quadraticRoots(1,-2,1);
    }
}
