package trees.learning;

import trees.TreeNode;

public class FindNodeInBT {
    public trees.TreeNode findNode(trees.TreeNode node, int value) {
        if (node == null) {
            return null; // base case: reached leaf, not found
        }
        if (node.val == value) {
            return node; // found the node with required value
        }
        // Search in the left subtree
        TreeNode leftResult = findNode(node.left, value);
        if (leftResult != null) {
            return leftResult; // found in left subtree
        }
        // Search in the right subtree
        return findNode(node.right, value);
    }
}
