package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree__2 {

    public static void main(String[] args) {
        ValidateBinarySearchTree__2 test = new ValidateBinarySearchTree__2();

        TreeNode root = new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
        );

        System.out.printf("true - " + test.isValidBST(root));
    }

    /**
     * memory: O(N + lnN), cpu: O(V + E)        
     * ln N - для массива, в худшем O(N) для массива
     *
     * cpu: O(V + E), где V — количество вершин, а E — количество ребер.
     * Пространственная сложность алгоритма равна O(V).
     */
    public boolean isValidBST(TreeNode root) {
        return solve(root, new ArrayList<>());
    }

    private boolean solve(TreeNode node, List<Pair> passNodes) {
        if (node == null) {
            return true;
        }

        if (!checkVals(node.val, passNodes)) {
            return false;
        }

        passNodes.add(passNodes.size()-1, new Pair(node.val, 'l'));
        boolean left = solve(node.left, passNodes);
        if (!left) return false;
        passNodes.remove(passNodes.size()-1);

        passNodes.add(passNodes.size()-1, new Pair(node.val, 'r'));
        boolean two = solve(node.right, passNodes);
        passNodes.remove(passNodes.size()-1);
        return two;
    }

    private boolean checkVals(int val, List<Pair> passNodes) {
        for (Pair pair: passNodes) {
            if (pair.direction == 'l' && pair.val <= val) {
                return false;
            }
            if (pair.direction == 'r' && pair.val >= val) {
                return false;
            }
        }
        return true;
    }

    public static class Pair {
        public int val;
        public char direction;

        Pair(int val, char direction) {
            this.val = val;
            this.direction = direction;
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
