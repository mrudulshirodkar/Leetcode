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
    int move = 0;
    public int distributeCoins(TreeNode root) {
        moves(root);
        return move;
    }
    public int moves(TreeNode node){
        if(node == null) return 0;
        
        int left = moves(node.left);
        int right = moves(node.right);
        
        move += Math.abs(left) + Math.abs(right);
        
        return left + right + node.val - 1;
    }
}