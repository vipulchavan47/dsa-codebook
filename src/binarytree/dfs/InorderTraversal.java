package binarytree.dfs;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
//     Recursive Inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inOrderTraversal(root,list);

        return list;
    }

    public void inOrderTraversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left,list);
        list.add(node.val);
        inOrderTraversal(node.right,list);
    }


//    ---------- Iterative approach
public List<Integer> inorderTraversalIteravtive(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> st = new Stack<>();

    // Pointer to traverse the tree
    TreeNode node = root;

    // Loop continues until all nodes are processed
    while (true) {
        // Go as left as possible, pushing nodes onto the stack
        if (node != null) {
            st.push(node);
            node = node.left;
        }
        else {
            // If no left node and stack is empty, traversal is complete
            if (st.isEmpty()) {
                break;
            }

            // Process the top node from the stack
            node = st.pop();

            // In inorder traversal, visit the node after its left subtree
            list.add(node.val);

            // Move to the right subtree
            node = node.right;
        }
    }

    return list;
}
}
