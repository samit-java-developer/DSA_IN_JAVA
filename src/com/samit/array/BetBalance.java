package com.samit.array;

public class BetBalance {
    public static void main(String[] args) {

    }
    static int betBalance(String s) {
        int betAmount=1;
        int amount=4;
        int n=s.length();
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if ((ch+"").equals("W")){
                amount+=betAmount;
            }else{
                betAmount*=2;
            }
        }
        return amount;
    }
}
