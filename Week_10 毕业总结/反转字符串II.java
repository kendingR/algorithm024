package com.ken.字符串;

public class 反转字符串II {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        int n = s.length();
        while (i < n) {
            reversePartialStr(chars, i, Math.min(i + k - 1, n - 1));
            i = i + 2 * k;
        }
        return String.valueOf(chars);
    }

    private void reversePartialStr(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
