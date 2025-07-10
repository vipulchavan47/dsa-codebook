package trees.easy;

import trees.TreeNode;

import java.util.*;

public class TreeLevelTraversalTwo {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currentLevel.add(currNode.val);

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            // whenever we add a new level list just add it at the start of the result (at 0 index)
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {

        // Constructing the following tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        // It should print the output from bottom to top

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode root = new TreeNode(1, node2, node3);
        
        List<List<Integer>> result = levelOrderBottom(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
