package com.ken.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N叉树的前序遍历 {

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while(!deque.isEmpty()){
            Node node = deque.pop();
            res.add(node.val);
            if(node.children!=null){
                for(int i=node.children.size()-1;i>=0;i--){
                    deque.push(node.children.get(i));
                }
            }
        }
        return res;
    }
}
