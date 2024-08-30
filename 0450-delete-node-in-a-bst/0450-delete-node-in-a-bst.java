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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key){
            if(root.right == null && root.left == null){
                return null;
            }
            else if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }
            else{
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }
            
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
    
    private TreeNode findMin(TreeNode node){
        if(node.left != null){
            node = findMin(node.left);
        }
        return node;
    }
}