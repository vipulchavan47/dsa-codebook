package binarytree.bfs;

import binarytree.TreeNode;

import java.util.*;

/*
(remember this)
To change a tree, you must hold node references.
Values alone can’t modify structure or state.
 */
public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean oddLevel = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> values = new ArrayList<>();


            /*
            why nodes are required:
            if I just store in list and reverse them how do you know where to swap them
                nodes  → [nodeA, nodeB, nodeC]
                values → [1,     2,     3]
            After reverse:
                values → [3, 2, 1]
                -so after reverse we can swap the values
                nodes.get(0).val = values.get(0); // nodeA ← 3
                nodes.get(1).val = values.get(1); // nodeB ← 2
                nodes.get(2).val = values.get(2); // nodeC ← 1

             */
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                nodes.add(curr);
                values.add(curr.val);

                if (curr.left != null){
                    q.offer(curr.left);
                }
                if (curr.right != null){
                    q.offer(curr.right);
                }

            }

            if(oddLevel){
                Collections.reverse(values);
                for(int i = 0; i < size; i++){
                    // get the node swap the reverse values from the list
                    nodes.get(i).val = values.get(i);
                }
            }

            oddLevel = !oddLevel;
        }

        return root;
    }
}
