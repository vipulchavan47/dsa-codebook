package trees.dfsproblems;

import java.util.ArrayList;
import java.util.List;

import binarytree.TreeNode;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. 
Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
*/
public class SumRootToLeaftNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();

        preorder(root, 0, nums);

        // Calculate the sum of all numbers in the list
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        return sum;
    }

    private void preorder(TreeNode node, int current, List<Integer> nums) {
        // Base case: if the node is null, return
        if(node == null){
            return;
        }

        // Update the current number by appending the node's value
        current = current * 10 + node.val;

        // If the node is a leaf, add the current number to the list
        if(node.left == null && node.right == null){
            nums.add(current);
            return;
        }

        // Recur for the left and right children
        preorder(node.left, current, nums);
        preorder(node.right, current, nums);
    }
}
