package com.ken;

public class 颠倒二进制位 {

    public int reverseBits(int n) {
        int reverseN = 0, high = 31;
        while (n > 0) {
            int bitValue = n & 1; //0或1
            reverseN += bitValue << high--;
            n = n >> 1;
        }
        return reverseN;
    }
}
