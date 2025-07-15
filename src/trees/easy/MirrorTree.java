package trees.easy;

import trees.TreeNode;

// Using recursion
public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // call function and pass the children of the root node
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode node1, TreeNode node2) {
        // if both nodes are null then return true
        if (node1 == null && node2 == null) {
            return true;
        }

        // if one is null and other is not then return false
        if (node1 == null || node2 == null) {
            return false;
        }

        // check their values and recursively call their next nodes in the tree ( see problem image)
        return (
                (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)
        );
    }
}

// Using BFS
/*
class Solution {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;
    }
}

 */