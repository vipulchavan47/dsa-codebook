package trees.learning;

import trees.TreeNode;

import java.util.Stack;


/*
Pre-order (NLR): Node → Left → Right
Used for copying trees, expression trees.

In-order (LNR): Left → Node → Right
Used for BSTs to get sorted order.

Post-order (LRN): Left → Right → Node
Used for deleting trees, evaluating expressions.
 */
public class DFS {
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Visit the node
        preOrder(node.left);              // Visit left subtree
        preOrder(node.right);             // Visit right subtree
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }


    // iterative preorder (stack)
    public void preOrderIterative(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        // push root node into the stack
        st.push(node);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            System.out.println(curr.val + "->");

            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }

    }

}


