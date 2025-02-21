package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depthLeft = solve(root.left, 1);
        int depthRight = solve(root.right, 1);

        return Math.max(depthLeft, depthRight);
    }

    private int solve(TreeNode node, int depth) {
        if (node == null) return depth;

        int depthLeft = solve(node.left, ++depth);
        int depthRight = solve(node.right, depth);

        return Math.max(depthLeft, depthRight);
    }
    
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
