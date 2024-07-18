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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String fullTree = treeTraverse(root);
        String subTree = treeTraverse(subRoot);
        
        return fullTree.contains(subTree);
    }
    
    public String treeTraverse(TreeNode node){
        if(node == null) return "Null";
        
        StringBuilder sb = new StringBuilder(".");
        sb.append(node.val);
        sb.append(treeTraverse(node.left));
        sb.append(treeTraverse(node.right));
        
        return sb.toString();
    }
}