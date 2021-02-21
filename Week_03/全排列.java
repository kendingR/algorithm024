package com.ken.Recursion;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, int index, List<Integer> permutation, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, index + 1, permutation, result);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
