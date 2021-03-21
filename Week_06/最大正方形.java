package com.ken.动态规划;

public class 最大正方形 {

    public int maximalSquare(char[][] matrix) {
        if (matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //初始化第一行和第一列的dp值，用于后续递推计算
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    /*public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        if (matrix[0].length == 0) return maxArea;
        int m = matrix.length, n = matrix[0].length;
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    side = Math.max(side, 1);
                    int maxSide = Math.min(m - i, n - j); //可能可以达到的最大边长
                    if (maxSide <= side) break;
                    //验证可以达到的最大边长
                    for (int k = 1; k < maxSide; k++) {
                        //先校验斜对角线的长度，方便后面计算边上的点是否符合条件
                        if (matrix[i + k][j + k] == '0') break;
                        //用一个boolean标识判断是否要结束内外两层循环
                        boolean updateFlag = true;
                        //计算边上的点是否符合条件
                        for (int p
                             = 0; p < k; p++) {
                            if (matrix[i + k][j + p] == '0' || matrix[i + p][j + k] == '0') {
                                updateFlag = false;
                                break;
                            }
                        }
                        if (!updateFlag) break;
                        //如果一路到底都是1，则可以更新本轮的边长
                        side = Math.max(side, k + 1);
                    }
                }
            }
        }

        maxArea = side * side;
        return maxArea;
    }*/
}
