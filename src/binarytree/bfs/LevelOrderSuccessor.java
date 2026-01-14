package binarytree.bfs;
import binarytree.TreeNode;

import java.util.*;

public class LevelOrderSuccessor {
        public TreeNode levelOrderSuccessor(TreeNode root, TreeNode target) {
            if (root == null) return null;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);

                if (curr == target) {
                    return queue.peek(); // next node in level order
                }
            }

            return null; // no successor
        }

}
