package binarytree.dfs;

import binarytree.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    int height(TreeNode node){
        // if leaf node return 0
        if(node == null){
            return 0;
        }

        // calculate left and right height
        int left = height(node.left);
        int right = height(node.right);

        // calculate and update the diameter
        diameter = Math.max(diameter, left + right + 1);
        return 1 + Math.max(left,right);
    }
}
