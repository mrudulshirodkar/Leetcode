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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorderMap);
    }
    private TreeNode build(int[] inorder, int istart, int iend, 
                           int[] postorder, int pstart, int pend, HashMap<Integer, Integer> inorderMap){
        if(istart > iend || pstart > pend) return null;
        
        TreeNode node = new TreeNode(postorder[pend]);
        int mid = inorderMap.get(postorder[pend]);
        int numbersLeft = mid - istart;
        
        node.left = build(inorder, istart, mid - 1, 
                          postorder, pstart, pstart+numbersLeft-1, inorderMap);
        
        node.right = build(inorder, mid+1, iend, 
                         postorder, pstart+numbersLeft, pend-1, inorderMap);
        
        return node;
        
    }
}