package com.samit.mathematics;

public class MatheMaticsRevised {

    public static void main(String[] args) {
        System.out.println(countDigits(10));
        System.out.println(isPalindrome(121));
        System.out.println(findTrailingZeros(10));
        System.out.println(gcd(98, 56));
    }

    static int countDigits(int n) {
        if (n<=0){
            return 0;
        }else {
            return countDigits(n/10)+1;
        }
    }

    static boolean isPalindrome(int n) {
        int rev = 0;
        int temp=n;
        while (temp>0) {
            rev = rev*10 + temp%10;
            temp/=10;
        }
        return (rev==n)?true:false;
    }

    static int findTrailingZeros(int n){
        if (n<0){
            return -1;
        }
        int count = 0;
        for (int i=5;n/i>=1;i=i*5){
            count=count+(n/i);
        }
        return count;
    }

    static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }




}
