package com.ken.Tree;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造一棵二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        int length = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return recurBuildTree(preorder, map, 0, length - 1, 0, length - 1);
    }

    private TreeNode recurBuildTree(int[] preorder, Map<Integer, Integer> map, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int inorderRoot = map.get(preorder[preorderRoot]);
        int leftTreeSize = inorderRoot - inorderLeft;
        root.left = recurBuildTree(preorder, map, preorderRoot + 1, preorderRoot + leftTreeSize, inorderLeft, inorderRoot - 1);
        root.right = recurBuildTree(preorder, map, preorderRoot + leftTreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
