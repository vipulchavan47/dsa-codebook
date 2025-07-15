package trees.dfsproblems;

import trees.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the tree is empty, there is no path, so return false
        if (root == null) {
            return false;
        }

        // Start DFS from the root, with current sum initialized to 0
        return findSum(root, 0, targetSum);
    }

    // Helper function to perform DFS while keeping track of the current path sum
    boolean findSum(TreeNode node, int currSum, int target) {
        // Base case: if the current node is null, return false (no path)
        if (node == null) {
            return false;
        }

        // Add the current node's value to the current path sum
        currSum += node.val;

        // If the current node is a leaf (no left or right child)
        if (node.left == null && node.right == null) {
            // Check if the current path sum equals the target sum
            return (currSum == target);
        }

        // Recursively check:
        // - If there is a path in the left subtree with the required sum
        // - OR if there is a path in the right subtree with the required sum
        // Return true if either subtree has a valid path sum
        return findSum(node.left, currSum, target) ||
                findSum(node.right, currSum, target);
    }

}

/*
// Better than above 
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}

 */