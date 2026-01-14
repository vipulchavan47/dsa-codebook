package binarytree.dfs;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// --- Preorder:  root-left-right
public class PreorderTraversal {

//    Iterative Pre order traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();

        // Start by pushing the root node onto the stack
        st.push(root);

        // Continue traversal until all nodes are processed
        while (!st.isEmpty()) {
            // Pop the top node from the stack
            root = st.pop();

            // In preorder traversal, we visit the root first
            result.add(root.val);

            // Push right child first so that left child is processed first
            // (stack follows LIFO order)
            if (root.right != null) {
                st.push(root.right);
            }

            // Push left child
            if (root.left != null) {
                st.push(root.left);
            }
        }

        return result;

    }

// Recursive preorder traversal
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preOrder(root,result);

        return result;
    }

    void preOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }
}
