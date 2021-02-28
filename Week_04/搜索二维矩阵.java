package com.ken.二分;

public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) return false;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int mIndex = mid / n;
            int nIndex = mid % n;
            if (matrix[mIndex][nIndex] == target) return true;
            if (matrix[mIndex][nIndex] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
