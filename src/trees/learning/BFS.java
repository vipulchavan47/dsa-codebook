package trees.learning;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // This will store the final level order traversal result.
        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return the empty result.
        if (root == null) {
            return result;
        }

        // We use a queue to keep track of nodes to process at each level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // start with the root node in the queue

        // We process nodes level by level until the queue becomes empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>(levelSize); // stores the values for the current level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll(); // remove the front node from the queue
                currentLevel.add(currNode.val);   // add its value to the current level list

                // If the current node has a left child, add it to the queue for the next level
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                // If the current node has a right child, add it to the queue for the next level
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            // After processing the current level, add the list of values to the final result
            result.add(currentLevel);
        }

        // Return the complete level order traversal list
        return result;
    }


    // Main method ------------
    public static void main(String[] args) {

        // Constructing the following tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode root = new TreeNode(1, node2, node3);

        // Perform level order traversal
        List<List<Integer>> result = levelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}


