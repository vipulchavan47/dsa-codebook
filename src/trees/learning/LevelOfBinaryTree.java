package trees.learning;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOfBinaryTree {
    public static int findLevel(TreeNode root, int target){
        if(root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size(); // nodes at current level

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();

                if(current.val == target){
                    return level;
                }

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            level++; // increment level after processing this level
        }

        return -1; // target not found
    }

}
