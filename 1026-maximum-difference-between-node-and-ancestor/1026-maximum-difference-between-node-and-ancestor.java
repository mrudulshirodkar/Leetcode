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
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return maxDiff;
    }
    
    private int helper(TreeNode node, int min, int max){
        if(node == null) return 0;
        
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        
        int current = Math.abs(max - min);
        maxDiff = Math.max(maxDiff, current);
        
        int left = helper(node.left, min, max);
        int right = helper(node.right, min, max);
        
        return maxDiff;
    }
}