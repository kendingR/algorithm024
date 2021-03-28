package com.ken;

public class 省份数量 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // 返回最终合并后的集合的数量
        return uf.size;
    }

    // 并查集
    static class UnionFind {
        int[] parents;
        int size; // 集合数量

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            size = n;
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
    }

     /*public int findCircleNum(int[][] isConnected) {
        int circleNum = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }*/
}
