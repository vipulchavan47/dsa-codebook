package binarytree.dfs;

import binarytree.TreeNode;

public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        // Base case:
        // If the tree (or subtree) is empty, its depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of the left subtree
        int left = maxDepth(root.left);

        // Recursively find the depth of the right subtree
        int right = maxDepth(root.right);

        // The depth at the current node is:
        // 1 (for the current node itself)
        // + the maximum depth of its left or right subtree
        return 1 + Math.max(left, right);
    }

}
