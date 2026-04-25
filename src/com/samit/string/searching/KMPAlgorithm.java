package com.samit.string.searching;

import java.util.*;
import java.io.*;
import java.lang.*;
  
public class KMPAlgorithm {


    public static boolean isRotated(String s1, String s2) {
        // code here
        int n = s1.length();
        if (s1.equals(s2)) {
            return false;
        }
        if (n > 2) {
            StringBuilder sb = new StringBuilder(s1.substring(2));
            sb.append(s1.charAt(0));
            sb.append(s1.charAt(1));
            boolean anti = s2.contentEquals(sb);

            sb = new StringBuilder(s1.substring(0, n - 2));
            String finalO=s1.substring(n-2,n)+sb.toString();
            boolean clock = s2.contentEquals(finalO);
            return anti || clock;
        }
        return false;
    }

    static void fillLPS(String str, int[] lps) {
        int n = str.length(), len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    static void KMP(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        int[] lps = new int[M];
        fillLPS(pat, lps);
        int i = 0, j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }
    public static void main(String args[]) 
    {   String txt = "ababcababaad",pat="ababa";
        KMP(pat,txt);
        String s1="daxjheq";
        String s2="eqdaxjh";
        boolean yes=isRotated(s1,s2);
        System.out.println(yes);
    }  
     
} 