package com.samit.string.searching;

public class RobinKarp {
    public static void main(String[] args) {
        String text="ABCABCD";
        String pat="ABCD";
        RBSearch(pat,text);
    }

    static void RBSearch(String pattern,String text){
        int m=pattern.length();
        int n=text.length();
        long h=1;
        long q = 1_000_000_009L;
        int d=5;
        for (int i=1;i<=m-1;i++){
            h=(h*d)%q;
        }
        double p=0.0,t=0.0;
        for (int i=0;i<m;i++){
            p=(p*d+pattern.charAt(i))%q;
            t=(t*d+text.charAt(i))%q;
        }
        for (int i=0;i<=(n-m);i++){
            if (p==t){
                boolean flag=true;
                for (int j=0;j<m;j++){
                    if (text.charAt(i+j)!=pattern.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    System.out.print(i+" ");
                }
            }
            if (i<n-m){
                t=((d*(t-text.charAt(i)*h))+text.charAt(i+m))%q;
                if (t<0){
                    t=t+q;
                }
            }
        }
    }
}
