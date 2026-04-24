/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // If root is smaller than low, left side is also smaller, so ignore left
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If root is greater than high, right side is also greater, so ignore right
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Root is valid, trim both sides
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}