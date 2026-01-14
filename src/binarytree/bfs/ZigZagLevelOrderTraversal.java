package binarytree.bfs;
import binarytree.TreeNode;

import java.util.*;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
 */
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean lefttoright = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                ans.add(curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }

            // use flag to determine which level to reverse and which not to
            if(!lefttoright){
                Collections.reverse(ans);
                result.add(ans);
                lefttoright = true;
            }
            else{
                result.add(ans);
                lefttoright = false;
            }

        }

        return result;
    }
}
