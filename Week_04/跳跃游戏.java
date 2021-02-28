package com.ken.贪心;

public class 跳跃游戏 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int toReach = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= toReach) toReach = i;
        }
        return toReach == 0;
    }
}
