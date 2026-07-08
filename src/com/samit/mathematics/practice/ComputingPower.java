package com.samit.mathematics.practice;

public class ComputingPower {

    static int power(int x,int n){
        if (n==0) return 1;
        int temp=power(x,n/2);
        if (n%2==0){
            return temp*temp;
        }else{
            return x*temp*temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        System.out.println(power(2,1));
    }

}
