package trees.easy;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class PreorderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }
}

