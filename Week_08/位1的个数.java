package com.ken;

public class 位1的个数 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    /*public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) count++;
        }
        return count;
    }*/
}
