package trees.learning;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    //populate tree
    public void populate(Scanner scanner) {
        // root node
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        // left nodes
        System.out.println("Do you want to insert to the left of : " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value to the left of :" + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        // right nodes
        System.out.println("Do you want to insert to the right of : " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value to the right of :" + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
