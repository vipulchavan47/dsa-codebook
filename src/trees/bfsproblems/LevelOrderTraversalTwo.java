package trees.bfsproblems;

import trees.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
Given the root of a binary tree, return the bottom-up 
level order traversal of its nodes' values. 
(i.e., from left to right, level by level from leaf to root).

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [[15,7],[9,20],[3]]
*/
public class LevelOrderTraversalTwo {
    // ------ Optimized BFS Approach ------
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();

        if (root == null)
            return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                curr.add(currNode.val);

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            ans.addFirst(curr);
        }

        return ans;
    }

    // My Initial Approach :
    public List<List<Integer>> levelOrderBottomBetter(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                curr.add(currNode.val);

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            ans.add(curr);
        }

        Collections.reverse(ans);
        return ans;
    }
}
