package com.samit.string;

import java.util.Arrays;

public class FrequenciesOfCharacter {
    public static void main(String[] args) {

        //Print Frequencies of Character (in sorted order )in a string of lower case alphabets.
        String input="geeksforgeeks";
        int[] count=new int[26];
        Arrays.fill(count,0);
        for (int i=0;i<input.length();i++){
            count[input.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if (count[i]>0){
                System.out.print((char)(i+97)+"-> ");
                System.out.println(count[i]);

            }
        }
    }

}
