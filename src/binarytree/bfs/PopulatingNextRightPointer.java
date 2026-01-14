package binarytree.bfs;

/*
You are given a perfect binary tree where all leaves are on the same level,
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointer {
    // BFS using queue approach
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node prev = null;

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            prev.next = null;
        }

        return root;

    }


    // More Optimal (Constant extra space)
    // Just see the diagram and connect them like a linked list (level by level)

    public Node connect2(Node root) {
        if (root == null) return null;

        Node leftmost = root; // start with the leftmost node of the current level

        // iterate level by level (perfect binary tree, so left child exists)
        while (leftmost.left != null) {
            Node curr = leftmost; // traverse nodes in the current level using next pointers

            while (curr != null) {
                // connect left child to right child of the same parent
                curr.left.next = curr.right;

                // connect right child to the left child of curr's next node (neighbor parent)
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                // move to next node in the same level
                curr = curr.next;
            }

            // move down to the leftmost node of the next level
            leftmost = leftmost.left;
        }

        return root;
    }

}
