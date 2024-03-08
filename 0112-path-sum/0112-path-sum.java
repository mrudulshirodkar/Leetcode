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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        
        path.push(root);
        sum.push(root.val);
        
        while(!path.isEmpty()){
            TreeNode tempnode = path.pop();
            int tempVal = sum.pop();
            
            if(tempnode.left == null && tempnode.right == null && tempVal == targetSum){
                return true;
            }
            
            if(tempnode.left != null){
                path.push(tempnode.left);
                sum.push(tempnode.left.val + tempVal);
            }
            
            if(tempnode.right != null){
                path.push(tempnode.right);
                sum.push(tempnode.right.val + tempVal);
            }
        }
        return false;
    }
}