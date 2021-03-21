package com.ken.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的前序遍历 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //解法1：递归
    //时间复杂度O(n) 空间复杂度O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) preorderTraversal(root.left, res);
        if (root.right != null) preorderTraversal(root.right, res);
    }

    /*//解法2：迭代，栈模拟递归
    //时间复杂度O(n) 空间复杂度O(1)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }
        return res;
    }*/

}
