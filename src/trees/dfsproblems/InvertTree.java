package trees.dfsproblems;

import trees.TreeNode;

// Invert a binary tree.
// Traversal: DFS (Preorder Traversal)
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        // Base case
        if (root == null) {
            return null;
        }

        // swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively call invertTree on left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        // Return the root of the inverted tree
        return root;
    }
}
