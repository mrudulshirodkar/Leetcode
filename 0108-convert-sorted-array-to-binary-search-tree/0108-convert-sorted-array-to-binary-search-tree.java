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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return buildTree(0, nums.length-1, nums);
    }
    
    public TreeNode buildTree(int first, int last, int[] nums){
        if(first > last){
            return null;
        }
        
        int middle = (first + last)/2;
        TreeNode node = new TreeNode(nums[middle]);
        
        node.left = buildTree(first, middle-1, nums);
        node.right = buildTree(middle+1, last, nums);
        
        return node;
    }
}