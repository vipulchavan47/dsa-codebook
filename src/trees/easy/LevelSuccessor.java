package trees.easy;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelSuccessor {
    public static TreeNode levelSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        // we just need the next element in the queue once we find the key
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            // push the nodes children
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }

            // break the loop
            if (currNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode root = new TreeNode(1, node2, node3);

        TreeNode successor = levelSuccessor(root, 1);
        if (successor != null) {
            System.out.println("Level successor is: " + successor.val);
        } else {
            System.out.println("Level successor not found.");
        }
    }

}
