package trees.dfsproblems;

import binarytree.TreeNode;

// Return the sum of left leaf nodes

public class SumOfLeftLeafs {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft){
        if(node == null){
            return 0;
        }

        // if its leaf node and left leaf node return its value
        if(node.left == null && node.right == null){
            return isLeft ? node.val : 0;
        }

        // set the flag of left node = true and right nodes = false and call the dfs for both left and right nodes
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
