package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] x;
        System.out.println(1/2);
//            Arrays.copyOfRange()

        ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
//        test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        test.sortedArrayToBST(new int[]{1, 3});
    }

    /*
    time: O(N)
    memory: O(N)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode root = new TreeNode();
//        build(root, nums, 'i');
        return buildRoot(nums);
    }

    public TreeNode buildRoot(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int medium = nums.length / 2;
        TreeNode root = new TreeNode(nums[medium]);

        build(root, Arrays.copyOfRange(nums, 0, medium), 'l');
        if (medium + 1 == nums.length) {
            return root;
        }
        build(root, Arrays.copyOfRange(nums, medium + 1, nums.length), 'r');
        return root;
    }

    public void build(TreeNode parent, int[] nums, char direction) {
        if (nums.length == 0) {
            return;
        }

        if (nums.length == 1) {
            if (direction == 'l') {
                parent.left = new TreeNode(nums[0]);
            }
            if (direction == 'r') {
                parent.right = new TreeNode(nums[0]);
            }
            return;
        }

        int medium = nums.length / 2;
        TreeNode node = new TreeNode(nums[medium]);
        if (direction == 'l') {
            parent.left = node;
        } else {
            parent.right = node;
        }

        build(node, Arrays.copyOfRange(nums, 0, medium), 'l');

        if (medium + 1 == nums.length) {
            return;
        }
        build(node, Arrays.copyOfRange(nums, medium + 1, nums.length), 'r');
    }

    // Definition for a binary tree node.
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
