package trees.easy;

import trees.TreeNode;

import java.util.*;

public class ZigzagLevelTraversal {

    public static List<List<Integer>> zigzagLevelOrderOptimal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                // if reverse is false means we need to remove from the front and add it in the back
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offerLast(currentNode.right);
                    }
                }
                // if reverse is true means we need to remove from the back and add it in the front
                else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    // Note: add children in reverse order when using pollLast
                    // add right first and then left while reversing
                    if (currentNode.right != null) {
                        queue.offerFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.offerFirst(currentNode.left);
                    }
                }
            }

            result.add(currentLevel);
            reverse = !reverse;
        }
        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // Use a queue for standard level order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0; // Track the current level to determine zigzag direction

        // While there are nodes to process
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> list = new ArrayList<>(); // List to store current level nodes

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll(); // Get the front node from the queue
                list.add(currNode.val); // Add its value to the current level list

                // Add left child to the queue if it exists
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                // Add right child to the queue if it exists
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            // If the level is odd (level % 2 != 0), reverse the list to achieve zigzag order
            if ((level % 2) != 0) {
                Collections.reverse(list);
            }
            // Add the current level list (reversed or not) to the result
            result.add(list);

            level++; // Move to the next level
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a simple binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        // Answer: [[1], [3,2], [4,5,6]]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = zigzagLevelOrderOptimal(root);

        // Print the zigzag level order result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
