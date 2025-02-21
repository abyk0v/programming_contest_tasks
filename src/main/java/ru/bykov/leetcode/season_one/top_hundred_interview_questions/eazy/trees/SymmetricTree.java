package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        List<TreeNode> currentNodes = new ArrayList<>();
        currentNodes.add(root.left);
        currentNodes.add(root.right);

        return solve(currentNodes);
    }

    private boolean solve(List<TreeNode> currentNodes) {
        List<TreeNode> nextNodes = new ArrayList<>();

        while (!currentNodes.isEmpty()) {
            // 1. проверка условия для уровня
            int leftIndex = 0;
            int rightIndex = currentNodes.size() - 1;
            while (leftIndex < rightIndex) {
                TreeNode left = currentNodes.get(leftIndex);
                TreeNode right = currentNodes.get(rightIndex);

                if (left == null && right != null) return false;
                if (left != null && right == null) return false;
                if (left == null && right == null) {
                    leftIndex += 1;
                    rightIndex -= 1;
                    continue;
                }
                if (left.val != right.val) {
                    return false;
                }

                leftIndex += 1;
                rightIndex -= 1;
            }

            // 2. переходим на следующий уровень
            for (TreeNode node: currentNodes) {
                if (node != null) {
                    nextNodes.add(node.left);
                    nextNodes.add(node.right);
                }
            }
            currentNodes = nextNodes;
            nextNodes = new ArrayList<>();
        }

        return true;
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }
}
