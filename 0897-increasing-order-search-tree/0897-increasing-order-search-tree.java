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
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode (0);
        cur = res;
        inorder(root);
        return res.right;
    }
    
    void inorder(TreeNode node){
        if(node==null){
            return ;
        }
        inorder(node.left);
        cur.right = node;
        node.left = null;
        cur = node;
        inorder(node.right);
    }
}
