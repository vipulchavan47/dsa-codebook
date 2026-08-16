package trees.dfsproblems;

import trees.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = 0;
    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return diameter - 1;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // diameter of the current node is the sum of the heights of left and right subtrees plus 1 for the current node
        int dia = leftHeight + rightHeight + 1;
        // update the maximum diameter found so far
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
