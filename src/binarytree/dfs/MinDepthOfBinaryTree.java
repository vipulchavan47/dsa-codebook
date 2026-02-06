package binarytree.dfs;

import binarytree.TreeNode;

public class MinDepthOfBinaryTree {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // If one subtree is missing,  take the other
            if (root.left == null && root.right == null) {
                return 1;
            }

            // if left tree is null , take the right
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }
            // if right tree is null , take the left
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }

            // if both children exist → take the smaller one
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
}
