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
    int res;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root, k);
        return res;
        
    }
    
    void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, k);
        if (--count == 0) {
            res = node.val;
            return;
        }
        inorder(node.right, k);
    }
}