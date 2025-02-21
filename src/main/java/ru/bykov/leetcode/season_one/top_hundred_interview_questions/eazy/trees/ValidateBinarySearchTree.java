package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        Deque<Integer> lessVals = new LinkedList<>();
        Deque<Integer> largeVals = new LinkedList<>();

        largeVals.addFirst(root.val);
        boolean leftResult = solve(root.left, lessVals, largeVals);

        largeVals.removeFirst();
        lessVals.addFirst(root.val);
        return leftResult && solve(root.right, lessVals, largeVals);
    }

    private boolean solve(TreeNode node,
                          Deque<Integer> lessVals,
                          Deque<Integer> largeVals) {
        if (node == null) return true;

        for(Integer i: lessVals) {
            if (node.val <= i) return false;
        }
        for(Integer i: largeVals) {
            if (node.val >= i) return false;
        }

        largeVals.addFirst(node.val);
        boolean leftResult = solve(node.left, lessVals, largeVals);

        largeVals.removeFirst();
        lessVals.addFirst(node.val);
        boolean rightResult = solve(node.right, lessVals, largeVals);

        lessVals.removeFirst();
        return leftResult && rightResult;
    }
    
    
    public static class TreeNode {
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
