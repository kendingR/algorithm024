package com.ken.RecursionorDFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class 岛屿数量 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        if (n == 0) return count;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int i, int j, int m, int n) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            i = coordinate[0];
            j = coordinate[1];
            if (i < m && j < n && i >= 0 && j >= 0 && grid[i][j] == '1') {
                grid[i][j] = 0;
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i, j + 1});
                queue.offer(new int[]{i, j - 1});
            }
        }
    }
}
