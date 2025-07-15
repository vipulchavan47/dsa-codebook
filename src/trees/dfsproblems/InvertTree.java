package trees.dfsproblems;

import trees.TreeNode;


// Pre-order: first invert left , right and then root
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        // Base Case: if the current node is null, return null
        // This stops further recursion when we reach the end of a branch.
        if (root == null) {
            return null;
        }

        // Recursively call invertTree on the left subtree
        // This will invert the entire left subtree first before returning
        TreeNode leftNode = invertTree(root.left);

        // Recursively call invertTree on the right subtree
        // This will invert the entire right subtree
        TreeNode rightNode = invertTree(root.right);

        // After inverting left and right subtrees,
        // we swap the left and right children of the current root
        root.left = rightNode;  // The inverted right subtree becomes the new left child
        root.right = leftNode;  // The inverted left subtree becomes the new right child

        // Return the current root with its children swapped
        // This ensures the parent call can attach this correctly
        return root;
    }
}

