package com.ken.二分;

public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) return false;
        int[] nums = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = matrix[i][j];
            }
        }
        return binarySearchTarget(nums, target);
    }

    private static boolean binarySearchTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
