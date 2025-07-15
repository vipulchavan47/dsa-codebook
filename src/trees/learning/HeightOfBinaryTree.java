package trees.learning;

import trees.TreeNode;

public class HeightOfBinaryTree {
    public int height(TreeNode node) {
        if (node == null) {
            return -1; // or return 0 if you define leaf node height as 1
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
