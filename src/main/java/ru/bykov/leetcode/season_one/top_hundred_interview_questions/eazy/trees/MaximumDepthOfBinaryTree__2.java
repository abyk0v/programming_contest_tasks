package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

public class MaximumDepthOfBinaryTree__2 {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree__2 test = new MaximumDepthOfBinaryTree__2();
        System.out.println("1. 0, а получили: " + test.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode node, int maxDepth) {
        if (node == null) {
            return maxDepth;
        }

        maxDepth += 1;
        return Math.max(
                solve(node.right, maxDepth),
                solve(node.left, maxDepth)
        );
    }


   // Definition for a binary tree node.
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
