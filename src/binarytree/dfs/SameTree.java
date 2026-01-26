package binarytree.dfs;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    //    DFS Solution (Better Here)
    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        // Base case 1: if both are null return true
        if (p == null && q == null) return true;

        // Base case 2: if one is null and other is not null or their value do not match return false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // recursively check the left and right subtree
        return isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right);
    }

    // BFS Solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if (n1.val != n2.val) return false;


            if (n1.left == null ^ n2.left == null) return false;
            if (n1.left != null) {
                q1.offer(n1.left);
                q2.offer(n2.left);
            }


            if (n1.right == null ^ n2.right == null) return false;
            if (n1.right != null) {
                q1.offer(n1.right);
                q2.offer(n2.right);
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
