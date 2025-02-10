package ru.bykov.leetcode.season_one.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class task94_Binary_Tree_Inorder_Traversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) traversal(node.left, list);
        if (node.right != null) traversal(node.right, list);
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
