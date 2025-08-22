package com.samit.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDigits {
    private static final Map<Integer,String> possible =new HashMap<Integer,String>();
    static{
        possible.put(1,"");
        possible.put(2,"abc");
        possible.put(3,"def");
        possible.put(4,"ghi");
        possible.put(5,"jkl");
        possible.put(6,"mno");
        possible.put(7,"pqrs");
        possible.put(8,"tuv");
        possible.put(9,"wxyz");
    }
    public static ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> list=new ArrayList<String>();
        possibleWordsInner(arr,0,list,"");
        return list;
    }
    public static void possibleWordsInner(int[] arr,int i,ArrayList<String> list,String res) {
        if (i==arr.length){
            list.add(res);
            return;
        }
        String str= possible.get(arr[i]);
        if (!str.isEmpty()){
            int size=str.length();
            for (int k=0;k<size;k++){
                char ch=str.charAt(k);
                possibleWordsInner(arr,i+1,list,res+ch);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={2,3};
        ArrayList<String> list=possibleWords(arr);
        System.out.println(list);
    }
}