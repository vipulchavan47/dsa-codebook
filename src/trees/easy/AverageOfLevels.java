package trees.easy;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// FInd the average of each level in tree
// Approach: BFS traversal

public class AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        // Create a list to store the average of each level
        List<Double> result = new ArrayList<>();

        // If the tree is empty, return the empty list
        if (root == null) {
            return result;
        }

        // Create a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node

        // Continue while there are nodes to process
        while (!queue.isEmpty()) {
            int level = queue.size(); // Number of nodes at the current level
            double ans = 0; // To store the sum of node values at the current level

            // Process all nodes at the current level
            for (int i = 0; i < level; i++) {
                TreeNode currNode = queue.poll(); // Remove the front node from the queue
                ans = ans + currNode.val; // Add its value to the sum

                // Add left child to the queue if it exists
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                // Add right child to the queue if it exists
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            // After processing the level, calculate the average
            ans = ans / (double) level;
            // Add the average to the result list
            result.add(ans);
        }

        // Return the list containing averages of each level
        return result;
    }

    // -----Main method:
    public static void main(String[] args) {
        // Create a sample tree:
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> averages = averageOfLevels(root);

        // Print the averages
        for (double avg : averages) {
            System.out.println(avg);
        }
    }

}
