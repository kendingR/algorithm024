package com.ken.Tree;

public class 二叉树的最近公共祖先 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        else if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        root.right = node6;
        node6.left = node7;
        node6.right = node8;
        TreeNode treeNode = lowestCommonAncestor(root, node1, node5);
        System.out.println(treeNode.val);
    }
}
