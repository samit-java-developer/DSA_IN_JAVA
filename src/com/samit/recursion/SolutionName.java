package com.samit.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SolutionName {
    
    static Map<Integer,String> map=new HashMap<Integer,String>();
    static{
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
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result=new ArrayList<String>();
        String input="";
        possibleWordsIn(arr,input,0,result);
        return result;
    }
    
    public void possibleWordsIn(int[] arr,String input,int i, ArrayList<String> result){
        if (i==arr.length){
            result.add(input);
            return;
        }
        String value=map.get(arr[i]);
        if (!value.isEmpty()){
            for(int k=0;k<value.length();k++){
               char ch=value.charAt(k);
               possibleWordsIn(arr,input+ch,i+1,result);
            }
        }else{
            possibleWordsIn(arr,input,i+1,result);
        }
        
    }

    public static void main(String[] args) {
        int[] arr={2,3,4};
        SolutionName sol=new SolutionName();
        System.out.println(sol.possibleWords(arr));
    }
}