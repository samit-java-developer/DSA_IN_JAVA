package com.samit.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NthNumberMadeOfPrimeDigits {

    public static void main(String[] args) {
        int n=21;
        System.out.println(giveFinalArr(n));
    }

    static int giveFinalArr(int n){
        List<Integer> list=new ArrayList<>(List.of(2,3,5,7));
        List<Integer> result=new ArrayList<>(list);
        for (int i=0;i<4;i++){
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            for (int j=0;j<4;j++){
                sb1.append(list.get(i));
                sb1.append(list.get(j));
                result.add(Integer.parseInt(sb1.toString()));
                sb1=new StringBuilder();
                for (int k=0;k<4;k++){
                    sb2.append(list.get(i));
                    sb2.append(list.get(j));
                    sb2.append(list.get(k));
                    result.add(Integer.parseInt(sb2.toString()));
                    sb2=new StringBuilder();
                }
            }
        }
        result.sort((o1,o2)->o1-o2);
        return result.get(n-1);
    }
}
