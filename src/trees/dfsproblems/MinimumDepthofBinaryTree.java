package trees.dfsproblems;

import trees.TreeNode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest 
path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
*/
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If the node is a leaf node, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left subtrees is null, we only consider the depth of the right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        // If right subtree is null, we only consider the depth of the left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both left and right subtrees are not null, we take the minimum of the two depths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
