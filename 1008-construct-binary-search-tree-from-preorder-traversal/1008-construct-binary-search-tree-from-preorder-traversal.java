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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return buildTree(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    private TreeNode buildTree(int[] preorder, int bound, int[] count){
        if(count[0] == preorder.length || preorder[count[0]] > bound) return null;
        TreeNode node = new TreeNode(preorder[count[0]++]);
        node.left = buildTree(preorder, node.val, count);
        node.right = buildTree(preorder, bound, count);
        
        return node;
    }
}