package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.LinkedList;

public class SymmetricTree__2 {

    public static void main(String[] args) {
        LinkedList<TreeNode> leftSubtree = new LinkedList<>();
        leftSubtree.add(null);
        leftSubtree.removeFirst();
        System.out.printf("");
    }


    /**
     * memory: O(N), cpu: O(N)
     */
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> leftSubtree = new LinkedList<>();
        leftSubtree.add(root.left);
        LinkedList<TreeNode> rightSubtree = new LinkedList<>();
        rightSubtree.add(root.right);

        while (true) {
            if (leftSubtree.getFirst() == null && rightSubtree.getFirst() != null) {
                return false;
            }
            if (leftSubtree.getFirst() != null && rightSubtree.getFirst() == null) {
                return false;
            }
            if (leftSubtree.getFirst() != null && rightSubtree.getFirst() != null &&
                    leftSubtree.getFirst().val != rightSubtree.getFirst().val) {
                return false;
            }

            // заполняем справа на лево . -> .
            if (leftSubtree.getFirst() != null) {
                leftSubtree.addLast(leftSubtree.getFirst().left);
                leftSubtree.addLast(leftSubtree.getFirst().right);
            }
            leftSubtree.removeFirst();

            // заполняем слева на право . <- .
            if (rightSubtree.getFirst() != null) {
                rightSubtree.addLast(rightSubtree.getFirst().right);
                rightSubtree.addLast(rightSubtree.getFirst().left);
            }
            rightSubtree.removeFirst();


            if (leftSubtree.isEmpty() || rightSubtree.isEmpty()) {
                return true;
            }
        }
    }

    //   Definition for a binary tree node.
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
