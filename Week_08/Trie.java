package com.ken;

public class Trie {

    private TrieNode root;

    //构造方法初始化根节点
    public Trie() {
        root = new TrieNode();
    }

    //将单词插入字典树
    //时间复杂度O(n) 空间复杂度O(n)
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    //查找是否存在该单词
    //时间复杂度O(n) 空间复杂度O(1)
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    //查找是否存在符合该前缀的单词
    //时间复杂度O(n) 空间复杂度O(1)
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.containsKey(c)) {
                return null;
            }
            node = node.get(c);
        }
        return node;
    }

    class TrieNode {
        // 当前字典树节点维护与之关联的节点的引用
        private TrieNode[] children;
        // 如果每个节点只包含26个英文字母的话，则每个节点最多关联26个子节点
        private final int childrenNum = 26;
        // 标识当前路径是否走到末尾了,即从根节点走到此处构成一个完整的单词
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[childrenNum];
        }

        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
