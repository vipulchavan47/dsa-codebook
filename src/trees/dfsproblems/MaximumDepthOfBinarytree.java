package trees.dfsproblems;
import trees.TreeNode;
 
public class MaximumDepthOfBinarytree {
    // Formula : 1 + max(leftHeight, rightHeight)
      public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        
        // Constructing the following tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        MaximumDepthOfBinarytree solution = new MaximumDepthOfBinarytree();
        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth); // Output: 3
    }
}
