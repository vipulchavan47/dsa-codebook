package trees.dfsproblems;

import trees.TreeNode;

public class DepthOfBinarytree {
    public int maxDepth(TreeNode root) {
        // if it is the leaf node we'll return 0
        if (root == null) {
            return 0;
        }

        // go into the left subtree
        int left = maxDepth(root.left);
        // go into the right subtree
        int right = maxDepth(root.right);

//        calculate the depth at that node and add one for that node
        int depth = Math.max(left, right) + 1;
        return depth;

    }
}
