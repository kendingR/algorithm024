package com.ken.动态规划;

public class 最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
