package trees.dfsproblems;

import trees.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both are null then true
        if (p == null && q == null) {
            return true;
        }
        // if only one is null and other one is not then fasle
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) { // Compare current node values
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
