package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7))
        );

        System.out.printf("[[3],[9,20],[15,7]] - " + test.levelOrder_oneStack(root));
    }

    /*
    time: O(N)
    memory: O(3N) => O(N)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        Deque<TreeNode> nextLevel = new ArrayDeque<>();

        List<List<Integer>> answer = new ArrayList<>();
        while (true) {
            List<Integer> rowAnswer = new ArrayList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode processed = currentLevel.pop();

                rowAnswer.add(processed.val);

                if (processed.left != null) {
                    nextLevel.add(processed.left);
                }
                if (processed.right != null) {
                    nextLevel.add(processed.right);
                }
            }

            answer.add(rowAnswer);
            if (nextLevel.isEmpty()) {
                break;
            }

            rowAnswer = new ArrayList<>();
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }
        return answer;
    }

    public List<List<Integer>> levelOrder_oneStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        List<List<Integer>> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            int len = stack.size();
            ArrayList<Integer> newLevel = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = stack.poll();

                newLevel.add(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }

            answer.add(newLevel);
        }
        return answer;
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
