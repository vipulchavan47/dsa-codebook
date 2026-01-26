package binarytree.bfs;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i=0;i<levelSize;i++){
                TreeNode curr = q.poll();

                /* if it's the last node of the level add its value to the list */
                if(i == (levelSize -1)){
                    list.add(curr.val);
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }

            }

        }

        return list;
    }
}
