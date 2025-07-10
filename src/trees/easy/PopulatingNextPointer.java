package trees.easy;

public class PopulatingNextPointer {
    public Node connect(Node root) {
        // If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // We start with the leftmost node of the current level, initially root
        Node leftmost = root;

        // Since it is a perfect binary tree, we can use leftmost.left to know if we have another level
        while (leftmost.left != null) {
            // Start with the leftmost node of the current level
            Node current = leftmost;

            // Traverse all nodes in the current level using 'next' pointers
            while (current != null) {
                // Connect the left child to the right child
                current.left.next = current.right;

                // If there is a next node at the current level,
                // connect the current's right child to the next node's left child
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to the next node in the current level
                current = current.next;
            }

            // Move down to the next level
            leftmost = leftmost.left;
        }

        // Return the root with updated 'next' pointers
        return root;
    }

    ;

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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
}
