package binarytree.dfs;

import binarytree.TreeNode;

public class IsCousins {
        public boolean isCousins(TreeNode root, int x, int y) {
            // First, find the actual TreeNode objects for values x and y
            TreeNode xnode = findNode(root, x);
            TreeNode ynode = findNode(root, y);

            // Find the depth/level of each node in the tree (root is at level 0)
            int levelX = findLevel(root, xnode, 0);
            int levelY = findLevel(root, ynode, 0);

            // Nodes are cousins if they're at the same level AND not siblings
            return ((levelX == levelY) && !isSibling(root, xnode, ynode));
        }

        /**
         * Recursively searches the tree to find the node with the given value.
         * Uses DFS (depth-first search) to traverse the tree.
         * @return the TreeNode with the matching value, or null if not found
         */
        TreeNode findNode(TreeNode node, int value) {
            // Base case: if we've reached a null node, the value isn't here
            if(node == null) return null;

            // If current node has the value we're looking for, return it
            if(node.val == value) {
                return node;
            }

            // Recursively search the left subtree
            TreeNode left = findNode(node.left, value);
            if(left != null) {
                // Found it in the left subtree, return it
                return left;
            }

            // Not in left subtree, so search the right subtree
            return findNode(node.right, value);
        }

        /**
         * Recursively finds the depth/level of a specific node in the tree.
         * The root is at level 0, its children at level 1, etc.
         *
         * @param root - current node being examined
         * @param node - the node whose level we're trying to find
         * @param level - the current level/depth in the tree
         * @return the level of the target node, or -1 if not found
         */
        int findLevel(TreeNode root, TreeNode node, int level) {
            // Base case: reached a null node, target not found in this path
            if(root == null) {
                return -1;
            }

            // Found the target node! Return its current level
            if(root == node) {
                return level;
            }

            // Search left subtree at the next level down (level + 1)
            int leftLevel = findLevel(root.left, node, level + 1);
            if(leftLevel != -1) {
                // Found it in the left subtree, return that level
                return leftLevel;
            }

            // Not in left subtree, search right subtree at the next level down
            return findLevel(root.right, node, level + 1);
        }

        /**
         * Checks if two nodes are siblings (share the same parent).
         * Recursively traverses the tree looking for a parent node that has
         * both xnode and ynode as its children.
         */
        boolean isSibling(TreeNode root, TreeNode xnode, TreeNode ynode) {
            // Base case: reached a null node, can't be their parent
            if(root == null) {
                return false;
            }

            // Check if current node is the parent of both xnode and ynode
            // This happens when one is the left child and the other is the right child
            if((root.left == xnode && root.right == ynode) ||
                    (root.left == ynode && root.right == xnode)) {
                return true;
            }

            // Current node isn't their parent, so recursively check both subtrees
            // If either subtree finds them as siblings, return true
            return isSibling(root.left, xnode, ynode) ||
                    isSibling(root.right, xnode, ynode);
        }
}
