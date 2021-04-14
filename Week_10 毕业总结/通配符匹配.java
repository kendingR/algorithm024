package com.ken.字符串;

public class 通配符匹配 {

    // abc ab*c
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; //都是空串的情况下是匹配的
        for (int i = 1; i <= n; i++) {
            //在s为空串，p非空的情况下只有全是'*'才能匹配上
            if (p.charAt(i - 1) != '*') break;
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
