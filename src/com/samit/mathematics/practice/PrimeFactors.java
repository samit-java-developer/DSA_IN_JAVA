package com.samit.mathematics.practice;

public class PrimeFactors {
    public static void main(String[] args) {
        findPrimeFactor(factorial(11));
        int x=getTrailingZerosInFactorial(50);
        System.out.println();
        System.out.println(x);
    }

    static int factorial(int n){
        if (n==0 || n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    static int getTrailingZerosInFactorial(int n){
        int count=0;
        int i=5;
        while (n/i>=1){
            count=count+(n/i);
            i=i*5;
        }
        return count;
    }

    static void findPrimeFactor(int n){
        while (n%2==0 && n!=1){
            n=n/2;
            System.out.print(2+" ");
        }
        while (n%3==0 && n!=1){
            n=n/3;
            System.out.print(3+" ");
        }
        for (int i=5;n!=1;i=i+6){
            while (n%i==0){
                n=n/i;
                System.out.print(i+" ");
            }
            while (n%(i+2)==0){
                n=n/(i+2);
                System.out.print((i+2)+" ");
            }
        }
    }
}
