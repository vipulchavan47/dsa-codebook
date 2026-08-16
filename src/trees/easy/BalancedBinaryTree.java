package trees.easy;

import trees.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) {
            return true;
        }

        // Calculate heights of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the current node is balanced if not return false
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        // Recursively check if left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // helper function to calculate the height of a subtree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
