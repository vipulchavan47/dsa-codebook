package trees.dfsproblems;

import trees.TreeNode;

public class MaximumPathSum {
        private int maxSum = Integer.MIN_VALUE;  // variable to track global max

        public int maxPathSum(TreeNode root) {
            findMaxPathSum(root);
            return maxSum;
        }

        private int findMaxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // Get max path from left subtree (at least 0, ignore negative paths)
            int left = Math.max(0, findMaxPathSum(root.left));
            // Get max path from right subtree (at least 0, ignore negative paths)
            int right = Math.max(0, findMaxPathSum(root.right));

            // Max path through this node = left + node + right
            maxSum = Math.max(maxSum, left + right + root.val);

            // Return single path for parent: max of (left + node) or (right + node)
            return Math.max(left, right) + root.val;
        }
}


/*
For each node, we compute two things:

1. Global Maximum (for this subtree):
    maxSum = left_max_path + node_value + right_max_path

2. Return Value (max path ending at this node, for parent):
    return max(left_max_path, right_max_path) + node_value
 */