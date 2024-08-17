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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return splitTree(preorder, inorderMap, 0, 0, inorder.length-1);
    }
    
    private TreeNode splitTree(int[] preorder, HashMap<Integer, Integer> inorderMap, int root, int left, int right){
        TreeNode node = new TreeNode(preorder[root]);
        
        int mid = inorderMap.get(preorder[root]);
        if(mid > left){
            node.left = splitTree(preorder, inorderMap, root + 1, left, mid-1);
        }
        if(mid < right){
            node.right = splitTree(preorder, inorderMap, root+mid-left+1, mid+1, right);
        }
        return node;
    }
}