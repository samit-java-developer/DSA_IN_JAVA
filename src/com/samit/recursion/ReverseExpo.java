package com.samit.recursion;

public class ReverseExpo {

    public static void main(String[] args) {
        int n=2;
        int ans=reverseExponentiation(n);
        System.out.println(ans);
        int res=power(n,ans);
        System.out.println(res);
    }

    public static int reverseExponentiation(int n) {
        int reverse=0;
        while (n!=0){
            reverse=reverse*10+(n%10);
            n=n/10;
        }
        int answer=power(n,reverse);
        return answer;
    }

    public static int power(int x,int n){
        if (n==0){
            return 1;
        }
        if (n<=1){
            return x;
        }
        if (n%2==0){
            x=x*x;
            n=n/2;
            return power(x,n);
        }else{
            return x*power(x,n-1);
        }
    }
}
