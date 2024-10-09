package com.samit.recursion;
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while(t-- > 0)
			{
			    int n = sc.nextInt(); 
			    int arr[] = new int[n]; 
			    
			    for(int i = 0; i < n; i++)
			       arr[i] = sc.nextInt();
				ArrayList <String> res = Solution.possibleWords(arr, n);
			    for (String i : res) System.out.print (i + " ");
			     System.out.println();
			      
			}
		}
    }
}

class Solution
{
    static Map<Integer,String> map=new HashMap<Integer,String>();
    static {
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }
  
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> res=new ArrayList<String>();
        possible(a,N,0,res,"");
        return res;
    }
    
    static void possible(int a[], int N,int i,ArrayList<String> res,String s){
        if (i==N){
            res.add(s);
            return;
        }
        String possibleChar=map.get(a[i]);
        if (!possibleChar.isEmpty()) {
        	for (int k=0;k<possibleChar.length();k++){
                possible(a,N,i+1,res,s+possibleChar.charAt(k));
            }
        }else {
        	possible(a, N, i+1, res, s);
        }
    }
}


