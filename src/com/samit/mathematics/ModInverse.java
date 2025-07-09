package com.samit.mathematics;

public class ModInverse {
    public static void main(String[] args) {
        int res=modInverse(3,11);
        System.out.println(res);
        res=modInverse(10,17);
        System.out.println(res);
    }
    static int modInverse(int n,int m){
        // if a*b under mod m is equal to 1 then b is the modulo inverse of a;
        for (int i=1;i<m;i++){
            if (((n%m) *(i%m))%m==1){
                return i;
            }
        }
        return -1;
    }
}
