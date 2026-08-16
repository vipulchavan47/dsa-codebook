package trees.bfsproblems;

import trees.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


// classic BFS just keep track of the level and sum of each level and return the level with maximum sum
public class MaximumLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;
        int level = 0;
        int result = 0;

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                levelSum += currNode.val;

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            level++;

            // if levelSum is greater than sum, update result to current level
            if (levelSum > sum) {
                result = level;
            }
            sum = Math.max(sum, levelSum);
        }

        return result;
    }
}
