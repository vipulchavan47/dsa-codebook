package trees.easy;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountTreeNodes {
    // Better O(N) : Using BFS
    public int countNodes(TreeNode root) {
        int result = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int count = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                count++;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result += count;
        }

        return result;
    }
}
