package com.ken;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class 最小基因变化 {

    //双向BFS
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(end)) return -1;
        if (bankSet.contains(start)) bankSet.remove(start);
        Set<String> existSet = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        beginSet.add(start);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);
        int minMutation = 0;
        char[] options = new char[]{'A', 'C', 'G', 'T'};

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for (String gene : beginSet) {
                char[] chars = gene.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char pre = chars[j];
                    for (char option : options) {
                        if (pre == option) continue;
                        chars[j] = option;
                        String newGene = String.valueOf(chars);
                        if (endSet.contains(newGene)) return ++minMutation;
                        if (!existSet.contains(newGene) && bankSet.contains(newGene)) {
                            tempSet.add(newGene);
                            existSet.add(newGene);
                        }
                    }
                    chars[j] = pre;
                }
            }
            beginSet = tempSet;
            ++minMutation;
        }
        return -1;
    }

    //BFS
    /*public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(end)) return -1;
        if (bankSet.contains(start)) bankSet.remove(start);
        Set<String> existSet = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int minMutation = 0;
        char[] options = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                char[] chars = gene.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char pre = chars[j];
                    for (char option : options) {
                        if (pre == option) continue;
                        chars[j] = option;
                        String newGene = String.valueOf(chars);
                        if (newGene.equals(end)) return ++minMutation;
                        if (!existSet.contains(newGene) && bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            existSet.add(newGene);
                        }
                    }
                    chars[j] = pre;
                }
            }
            ++minMutation;
        }
        return -1;
    }*/
}
