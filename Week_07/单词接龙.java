package com.ken;

import java.util.*;

public class 单词接龙 {

    //双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); //将字典放入哈希表，加快查找效率
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> existSet = new HashSet<>();
        int minStep = 0;
        while (!beginWord.isEmpty() && !endSet.isEmpty()) {
            //每次遍历数量少的set效率更高
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            ++minStep;
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    //针对字符串的每一位遍历26个字母替换该位字母，看是否在wordSet里
                    for (char c = 'a'; c <= 'z'; c++) {
                        char pre = chars[i];
                        if (pre == c) continue;
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        //双向BFS在对方的Set中找到了相同的单词则表示双向搜索相遇了，可以直接返回
                        if (endSet.contains(newWord)) return ++minStep;
                        if (!existSet.contains(newWord) && wordSet.contains(newWord)) {
                            temp.add(newWord);
                            existSet.add(newWord);
                        }
                        //回滚这一层遍历的状态
                        chars[i] = pre;
                    }
                }
            }
            beginSet = temp;
        }
        return 0;
    }

    //BFS
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); //将字典放入哈希表，加快查找效率
        if (!wordSet.contains(endWord)) return 0;
        Set<String> existSet = new HashSet<>(); //访问过的节点去重用的哈希表
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int minStep = 0;
        while (!queue.isEmpty()) {
            //每做一轮BFS，步数就+1
            ++minStep;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    //针对字符串的每一位遍历26个字母替换该位字母，看是否在wordSet里
                    for (char c = 'a'; c <= 'z'; c++) {
                        char pre = chars[i];
                        if (pre == c) continue;
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        //找到最终答案就返回
                        if (newWord.equals(endWord)) return ++minStep;
                        //探索过的节点就不再处理，这一轮符合条件的节点带入下一轮BFS
                        if (!existSet.contains(newWord) && wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            existSet.add(newWord);
                        }
                        //回滚这一层遍历的状态
                        chars[i] = pre;
                    }
                }
            }
        }
        return 0;
    }*/
}
