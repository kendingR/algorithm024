package com.ken;

public class 二的幂 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /*public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if (n == 1) return true;
            if ((n & 1) != 0) return false;
            n = n >> 1;
        }
        return false;
    }*/
}
