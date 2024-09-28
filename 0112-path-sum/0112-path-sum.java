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
        if(root == null) return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> pathSum = new Stack<>();
        path.push(root);
        pathSum.push(root.val);
        
        while(!path.isEmpty()){
            TreeNode node = path.pop();
            int sum = pathSum.pop();
            if(sum == targetSum && node.left == null && node.right == null) return true;
            if(node.left != null){
                path.push(node.left);
                pathSum.push(sum + node.left.val);
            }
            if(node.right != null){
                path.push(node.right);
                pathSum.push(sum + node.right.val);
            }
        }
        return false;
    }
}