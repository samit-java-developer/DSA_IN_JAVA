package com.samit.bitmagic;

public class SwapEvenAndOddBits {

    public static void main(String[] args) {
        int n=23;
        //Step 1: What is 0x55555555?
        //The prefix 0x means the number is in hexadecimal.

        //Each hexadecimal digit represents 4 binary bits.

//        Hex  Binary
//        0    0000
//        1    0001
//        2    0010
//        3    0011
//        4    0100
//        5    0101
//        6    0110
//        7    0111
//        8    1000
//        9    1001
//        A    1010
//        B    1011
//        C    1100
//        D    1101
//        E    1110
//        F    1111

        int even=n&0x55555555;
        int odd=n&0xAAAAAAAA;
        even=even<<1;
        odd=odd>>1;
        System.out.println(even|odd);
    }
}
