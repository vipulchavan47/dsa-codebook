package trees.dfsproblems;

import binarytree.TreeNode;

/*
Given the root of a Binary Search Tree (BST),
return the minimum absolute difference between the values of
any two different nodes in the tree.

Input: root = [4,2,6,1,3]
Output: 1
 */
public class MinimumAbsoluteDiff {
    // ----- Optimized DFS Approach -----
    int prev = -1;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);

        if(prev != -1){
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;

        inorder(node.right);
    }

    /*  ----- BFS Approach -----------
        public int getMinimumDifference(TreeNode root) {

            List<Integer> values = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();

                values.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            // sort the list
            Collections.sort(values);

            int minDiff = Integer.MAX_VALUE;

            // compare the adjacent values and update the min
            for(int i=1; i<values.size(); i++){
                minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
            }

            return minDiff;
    }
     */
}
