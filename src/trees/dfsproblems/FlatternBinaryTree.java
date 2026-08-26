package trees.dfsproblems;

import trees.TreeNode;

/* (Just do what you see)
If the current node has a left subtree,
go to the rightmost node of that left subtree. 
Store the current node's right subtree on the right of that rightmost node. 
Then move the entire left subtree to the current node's right, 
set the current node's left to null, and move current to the right.
*/

// Brute Force Approach : Time complexity is O(n) and space complexity is O(n).
//Traverse the tree in preorder and store the nodes in a list. 
// Then iterate through the list, set each node's left to null, 
// and set its right to the next node in preorder.

// Optimized Approach : Time complexity is O(n) and space complexity is O(1).
public class FlatternBinaryTree {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while(current != null){

            if(current.left != null){
                TreeNode temp = current.left;
                
                // go to rightmost of left subtree
                while(temp.right != null){
                    temp = temp.right;
                }

                // attach current's right subtree to the rightmost of left subtree
                temp.right = current.right;

                // move left subtree to the right
                current.right = current.left;

                // set left to null
                current.left = null;
            }

            // move to the right
            current = current.right;
        }
    }
}

/*
        current
        /     \
     LEFT     RIGHT

        ↓

        current
           \
           LEFT
             \
             RIGHT
*/