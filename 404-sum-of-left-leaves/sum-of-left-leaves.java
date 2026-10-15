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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        // Check if the left child is a leaf node
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val; // It's a left leaf! Add its value.
            } else {
                sum += sumOfLeftLeaves(root.left); // Continue looking in the left subtree
            }
        }
        
        // Always check the right subtree for potential left leaves
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}