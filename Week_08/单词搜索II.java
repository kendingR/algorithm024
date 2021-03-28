package com.ken;

import java.util.*;

public class 单词搜索II {

    //定义字典树方便DFS剪枝
    class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.setWord(word);
        }

        public TrieNode getRoot() {
            return root;
        }

        public void setRoot(TrieNode root) {
            this.root = root;
        }
    }

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String word; //字典树中单词的末尾节点存储单词全称，便于统计当前问题结果

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trieTree = new Trie();
        //构建字典树
        Arrays.stream(words).forEach(word -> trieTree.insert(word));
        //哈希表去重，防止DFS中二维矩阵存在重复结果
        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, m, n, board, trieTree.getRoot(), result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int i, int j, int m, int n, char[][] board, TrieNode node, Set<String> result) {
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '@') return;
        char c = board[i][j];
        //DFS走过的路径为了防止往回走，就用一个占位符标识路径已走过
        board[i][j] = '@';
        node = node.children[c - 'a'];
        //字典树剪枝
        if (node == null) {
            //状态回滚
            board[i][j] = c;
            return;
        }
        //字典树节点上发现有单词，则将单词加入结果集
        if (node.getWord() != null) {
            result.add(node.getWord());
        }
        //二维矩阵的四联通遍历
        dfs(i + 1, j, m, n, board, node, result);
        dfs(i - 1, j, m, n, board, node, result);
        dfs(i, j + 1, m, n, board, node, result);
        dfs(i, j - 1, m, n, board, node, result);
        //状态回滚
        board[i][j] = c;
    }
}
