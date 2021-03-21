package com.ken;

import java.util.*;

public class N皇后 {

    public List<List<String>> solveNQueens(int n) {
        //result结果集记录每一行的皇后所在列的下标
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        dfs(n, 0, cols, pie, na, new ArrayList(), result);
        //将结果集转换为题目要求的字符串结果
        return transferResult(result);
    }

    private void dfs(int n, int row, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, List<Integer> record, List<List<Integer>> result) {
        //递归终止条件
        if (row == n) result.add(new ArrayList<>(record));
        for (int i = 0; i < n; i++) {
            //剪枝
            if (cols.contains(i) || pie.contains(row - i) || na.contains(row + i)) continue;
            //记录状态
            cols.add(i);
            pie.add(row - i);
            na.add(row + i);
            record.add(i);
            //递归至下一层
            dfs(n, row + 1, cols, pie, na, record, result);
            //状态回滚
            cols.remove(i);
            pie.remove(row - i);
            na.remove(row + i);
            record.remove(record.size() - 1);
        }
    }

    private List<List<String>> transferResult(List<List<Integer>> list) {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> cols : list) {
            List<String> str = new ArrayList<>();
            for (Integer index : cols) {
                char[] chars = new char[cols.size()];
                Arrays.fill(chars, '.');
                chars[index] = 'Q';
                str.add(String.valueOf(chars));
            }
            result.add(str);
        }
        return result;
    }
}
