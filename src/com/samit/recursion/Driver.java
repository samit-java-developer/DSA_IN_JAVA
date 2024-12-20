package com.samit.recursion;
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

public class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());//testcases
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(reader.readLine());//input n
            //printing "1" if isLucky() returns true else "0"
            Solution1 s = new Solution1();
            System.out.println(s.isLucky(n)? "1" : "0");
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution1
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        return isLuckyInner(n,2);
    }
    
    public static boolean isLuckyInner(int n,int x)
    {
        if (n==0 || n==x){
            return false;
        }
        if (x>n){
            return true;
        }
        return isLuckyInner(n-(n/x),x+1);
    }
}