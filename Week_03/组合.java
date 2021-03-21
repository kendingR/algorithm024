package com.ken.Recursion;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return result;
        dfs(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int k, int index, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (n - index + 1 < k) return; //不带剪枝的条件 if(n-index<0) return;
        dfs(n, k, index + 1, combination, result);
        combination.add(index);
        dfs(n, k - 1, index + 1, combination, result);
        combination.remove(combination.size() - 1);
    }
}
