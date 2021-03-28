package com.ken;

public class 岛屿数量 {

    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union((i - 1) * n + j, i * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union((i + 1) * n + j, i * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j - 1, i * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j + 1, i * n + j);
                    }
                }
            }
        }
        return uf.getSize();
    }

    // 并查集
    static class UnionFind {
        int[] parents;
        int size; // 陆地数量

        public UnionFind(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            parents = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parents[n * i + j] = n * i + j;
                        size++;
                    }
                }
            }
        }

        public int find(int i) {
            if (i == parents[i]) {
                return i;
            }
            return parents[i] = find(parents[i]);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                parents[pRoot] = qRoot;
                size--;
            }
        }

        public int getSize() {
            return size;
        }
    }
}
