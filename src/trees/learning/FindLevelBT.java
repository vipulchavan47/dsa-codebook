package trees.learning;

import trees.TreeNode;

public class FindLevelBT {
    public  int findLevel(trees.TreeNode node, TreeNode x, int level) {
        if (node == null) {
            return -1; // base case: not found in this path
        }
        if (node == x) {
            return level; // found the node, return its level
        }
        // Search in the left subtree
        int leftLevel = findLevel(node.left, x, level + 1);
        if (leftLevel != -1) {
            return leftLevel; // found in left subtree
        }
        // Search in the right subtree
        return findLevel(node.right, x, level + 1);
    }
}
