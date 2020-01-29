package com.wind.newcoder;

public class TreeDfs {
    public <T> int minDepth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftLen = minDepth(node.left);
        int rightLen = minDepth(node.right);
        if (leftLen == 0 || rightLen == 0) {
            return leftLen + rightLen + 1;
        }
        return Math.min(leftLen, rightLen) + 1;
    }

    public <T> int maxDepth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftLen = maxDepth(node.left);
        int rightLen = maxDepth(node.right);
        if (leftLen == 0 || rightLen == 0) {
            return leftLen + rightLen + 1;
        }
        return Math.max(leftLen, rightLen) + 1;
    }

    public int minSum(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        int leftVal = minSum(node.left);
        int rightVal = minSum(node.right);
        if (leftVal == 0 || rightVal == 0) {
            return leftVal + rightVal + node.value;
        }
        return Math.min(leftVal, rightVal) + node.value;
    }
}
