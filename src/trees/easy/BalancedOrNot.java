package trees.easy;

import trees.TreeNode;

public class BalancedOrNot {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return (
                // absolute difference between heights (positive or negative) <= 1   ::: Math.abs(-1)=1
                Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)
        );

    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}
