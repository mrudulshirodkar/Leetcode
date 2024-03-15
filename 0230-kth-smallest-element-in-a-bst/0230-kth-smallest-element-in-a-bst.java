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
    int res[] = new int[1];
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root, k);
        return res[0];
        
    }
    
    void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, k);
        if (--count == 0) {
            res[0] = node.val;
            return;
        }
        inorder(node.right, k);
    }
}