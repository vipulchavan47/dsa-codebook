package trees.dfsproblems;

import trees.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        // if we find either p or q we return that node to the parent call
        if(root == p || root == q){
            return root;
        }

        // go to further left and right
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        // if the both left and right returned ans then curr node is the answer
        if(left != null && right != null){
            return root;
        }

        // if left ans is null then the both (p,q) lies in the right subtree and vice versa
        // where we have not searched yet so directly return the answer
        return left == null ? right : left;
    }
}
