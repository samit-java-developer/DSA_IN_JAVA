package com.samit.string.searching;

public class RobinKarp {
    public static void main(String[] args) {
       // String text="ABCABCD";
        //String pat="ABCD";
        //RBSearch2(pat,text);
        String s1="abcd";
        String s2="cdab";
        int n=s1.length();
        StringBuilder sb=new StringBuilder(s1);
        for (int i=0;i<n-1;i++){
            sb.append(s1.charAt(i));
            sb.deleteCharAt(0);
            if (sb.toString().equals(s2)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(true);
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
        for (int i=0;i<m;i++) {
            p = (p * d + pattern.charAt(i)) % q;
            t = (t * d + text.charAt(i)) % q;
        }
        System.out.println(p);
        System.out.println(t);
        int temp=1;
        p=0.0;
        t=0.0;
        // my approach....
        for (int i=m-1;i>=0;i--){
            p=p+(pattern.charAt(i)*temp);
            t=t+(text.charAt(i)*temp);
            temp=temp*d;
        }
        System.out.println(p);
        System.out.println(t);
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

    static void RBSearch2(String pattern,String text){
        int n=text.length();
        int m=pattern.length();
        double p=0.0,t=0.0;
        int d=5;
        long temp=1;
        long q = 1_000_000_009L;
        for (int i=m-1;i>=0;i--){
            p=p+(pattern.charAt(i)*temp);
            t=t+(text.charAt(i)*temp);
            temp=(temp*d)%q;
        }
        for (int i=0;i<=n-m;i++){
            if (p==t){
                int j;
                for (j=0;j<m;j++){
                    if (text.charAt(i+j)!=pattern.charAt(j)){
                        break;
                    }
                }
                if (j==m){
                    System.out.print(i+" ");
                }
            }
            if (i<n-m){
                t=((d*t-text.charAt(i)*temp)+text.charAt(i+m))%q;
                if (t<0){
                    t=t+q;
                }
            }
        }
    }
}
