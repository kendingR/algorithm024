package com.ken.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        // 对数组从小到大排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);

        List<int[]> result = new ArrayList<>();
        for (int[] array : intervals) {
            int left = array[0], right = array[1];
            // 结果集为空，或者结果集最后数组的右边界小于当前数组的左边界，则将当前数组加入结果集
            if (result.isEmpty() || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                //否则将当前数组和结果集的最后数组进行区间合并
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
