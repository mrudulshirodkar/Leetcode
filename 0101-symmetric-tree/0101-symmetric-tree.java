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
    public boolean isSymmetric(TreeNode root) {
        
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode leftroot, TreeNode rightroot){
        if(leftroot == null && rightroot == null) return true;
        
        if((leftroot != null && rightroot == null) || (leftroot == null && rightroot != null)) 
            return false;
        
        boolean root1 = check(leftroot.left, rightroot.right);
        boolean root2 = check(leftroot.right, rightroot.left);
        
        if(root1 && root2 && leftroot.val == rightroot.val) return true;
        else return false;
    }
}