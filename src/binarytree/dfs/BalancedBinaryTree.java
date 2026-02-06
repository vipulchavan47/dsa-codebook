package binarytree.dfs;

import binarytree.TreeNode;

public class BalancedBinaryTree {
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        int height(TreeNode node) {
            if (node == null) return 0;

            int left = height(node.left);
            if (left == -1) return -1;   // left subtree unbalanced

            int right = height(node.right);
            if (right == -1) return -1;  // right subtree unbalanced

            if (Math.abs(left - right) > 1) return -1;  // current node unbalanced

            return 1 + Math.max(left, right);
        }
}
