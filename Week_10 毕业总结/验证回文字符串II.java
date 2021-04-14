package com.ken.字符串;

public class 验证回文字符串II {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i + 1, j) || validPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
