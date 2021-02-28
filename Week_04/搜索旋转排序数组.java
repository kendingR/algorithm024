package com.ken.二分;

public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 0));
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //左半边单调，考虑只有两个元素的场景，left和mid会重合，所以需要加上=判断
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //右半边单调
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
