package com.ken.ArrayAndLinkedList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * medium
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class 前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int[] element = new int[2];
            element[0] = entry.getKey();
            element[1] = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(element);
            } else if (minHeap.peek()[1] < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(element);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
