package binarytree.dfs;

import binarytree.TreeNode;

public class SymmetricTree {
        public boolean isSymmetric(TreeNode root) {
            // An empty tree is symmetric
            if (root == null) {
                return true;
            }
            // Check if left and right subtrees are mirror images
            return isMirror(root.left, root.right);
        }

        boolean isMirror(TreeNode leftnode, TreeNode rightnode) {

            // Case 1: both nodes are null → symmetric at this position
            if (leftnode == null && rightnode == null) {
                return true;
            }

            // Case 2: one is null and the other is not → structure is not symmetric
            if (leftnode == null || rightnode == null) {
                return false;
            }

            // Case 3: values must be equal for mirror nodes
            if (leftnode.val != rightnode.val) {
                return false;
            }

            // Case 4:
            // leftnode.left should match rightnode.right (outer side)
            // leftnode.right should match rightnode.left (inner side)
            return isMirror(leftnode.left, rightnode.right) &&
                    isMirror(leftnode.right, rightnode.left);
        }
}
