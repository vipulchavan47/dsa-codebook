package trees.dfsproblems;

import trees.TreeNode;

/*
Given a binary tree root, 
a node X in the tree is named good 
if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

Time: O(n)
Space: O(h) recursion stack, where h is tree height.
*/
public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        // Start with the smallest possible value,
        // so the root will always be a good node.
        return helper(root, Integer.MIN_VALUE);
    }

    int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int result;

        // A node is "good" if its value is greater than
        // or equal to every value seen before it on this path.
        if (root.val >= max) {
            result = 1;
        } else {
            result = 0;
        }

        // Update the maximum value seen on the current path.
        // This value will be passed down to the children.
        max = Math.max(max, root.val);

        // Count good nodes in the left and right subtrees.
        result += helper(root.left, max);
        result += helper(root.right, max);

        // Return the total number of good nodes found in this subtree.
        return result;
    }
}


/* ---- For every node: ---

1. Is root.val >= max?
       ↓
2. If yes → count it
       ↓
3. Update max using root.val
       ↓
4. Pass max to children
*/