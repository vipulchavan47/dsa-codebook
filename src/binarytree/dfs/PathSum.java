package binarytree.dfs;

import binarytree.TreeNode;

public class PathSum {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;

            // If it's a leaf node
            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            }

            int remaining = targetSum - root.val;

            return hasPathSum(root.left, remaining)
                    || hasPathSum(root.right, remaining);
        }
}

/*
We visit every path (DFS).
We subtract current node value.
We only check equality at leaf.
|| ensures if either side returns true, we stop.
 */