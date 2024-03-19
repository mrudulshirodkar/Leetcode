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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftcount = diameterOfBinaryTree(root.left);
        int rightcount = diameterOfBinaryTree(root.right);
        
        int left = maxdepth(root.left) ;
        int right = maxdepth(root.right) ;
        
        return (Math.max(left + right, Math.max(leftcount, rightcount))) ;
        }
    
//         return (Math.max(left + right, Math.max(leftcount, rightcount))) ;
        
    
    // int count=0;
    public int maxdepth(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftTree = maxdepth(node.left);
        int rightTree = maxdepth(node.right);
        
        return (Math.max(leftTree, rightTree)+1);
    }

    
    
}