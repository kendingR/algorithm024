package com.ken.字符串;

public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        int begin = 0;
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                boolean equalFlag = s.charAt(i) == s.charAt(j);
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = equalFlag;
                } else {
                    dp[i][j] = equalFlag && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > maxLength) {
                    maxLength = l + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /*public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int length = s.length();
        int maxLength = 0, beginIndex = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length; j++) {
                if (j - i + 1 > maxLength && isValidPalindrome(s, i, j)) {
                    maxLength = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLength);
    }

    private boolean isValidPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }*/
}
