package com.samit.array.test;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr={6,8,7,6,6};
        int xx=majority(arr);
        System.out.println(xx);
    }

    static int majority(int[] arr){
        int candidate=0;
        int count=1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]==arr[candidate]){
                count++;
            }else{
                count--;
            }
            if (count==0){
                candidate=i;
                count=1;
            }
        }
        // now we received the candidate
        count=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==arr[candidate]){
                count++;
            }
        }
        if (count>(arr.length/2)){
            return arr[candidate];
        }
        return 0;
    }

}
