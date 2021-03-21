package com.ken.BFS;

import java.util.*;

public class 单词接龙 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); //将字典放入哈希表，加快查找效率
        int minStep = 0;
        if (!wordSet.contains(endWord)) return minStep;
        Set<String> graphSet = new HashSet<>(); //访问过的节点去重用的哈希表
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        //beginWord自己也算一步
        ++minStep;
        //每做一轮BFS，步数就+1
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int k = 0; k < beginWord.length(); k++) {
                    char pre = chars[k];
                    //针对字符串的每一位遍历26个字母替换该位字母，看是否在wordSet里
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (chars[k] == j) continue;
                        chars[k] = j;
                        String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord)) {
                            //找到最终答案就返回
                            if (newWord.equals(endWord)) return ++minStep;
                            //在字典里的话需要对已经访问过的节点通过graphSet去重，并将这些节点带到下一轮BFS里去
                            if (!graphSet.contains(newWord)) {
                                queue.offer(newWord);
                                graphSet.add(newWord);
                            }
                        }
                    }
                    chars[k] = pre;
                }
            }
            ++minStep;
        }
        return minStep;
    }
}
