package trees.easy;

import trees.TreeNode;

public class IsCousin {
    public static boolean isCousins(TreeNode root, int x, int y) {
        // Find the nodes with values x and y
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        // Return true if:
        // 1. Both nodes are at the same level
        // 2. They are not siblings
        return (findLevel(root, xx, 0) == findLevel(root, yy, 0)) &&
                (!isSibling(root, xx, yy));
    }

    /**
     * Recursively finds and returns the node with the given value in the tree.
     * If not found, returns null.
     */
    public static TreeNode findNode(TreeNode node, int value) {
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

    /**
     * Checks whether two nodes x and y are siblings (i.e., share the same parent).
     * Returns true if they are siblings, false otherwise.
     */
    public static boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false; // base case
        }
        // Check if current node has x and y as its left and right children
        if ((node.left == x && node.right == y) ||
                (node.left == y && node.right == x)) {
            return true;
        }
        // Recursively check in the left or right subtree
        return isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    /**
     * Finds the level (depth) of the given node x in the tree.
     * Root is at level 0.
     * If the node is not found in this path, returns -1.
     */
    public static int findLevel(TreeNode node, TreeNode x, int level) {
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

    public static void main(String[] args) {
        // Create the tree:
        //         1
        //        / \
        //       2   3
        //      /     \
        //     4       5

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        // Since isCousins is non-static, we will make it static for your use.
        boolean result = isCousins(root, 4, 5);
        System.out.println("Are 4 and 5 cousins? " + result); // Expected: true
    }

}
