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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        constructList(root, nums);
        return buildBalancedTree(0, nums.size()-1, nums);
    }
    private TreeNode buildBalancedTree(int first, int last, List<Integer> nums){
        if(first > last) return null;
        
        int middle = (first+last)/2;
        TreeNode node = new TreeNode(nums.get(middle));
        node.left = buildBalancedTree(first, middle-1, nums);
        node.right = buildBalancedTree(middle+1, last, nums);
        
        return node;
    }
    
    private void constructList(TreeNode node, List<Integer> nums){
        if(node == null){
            return;
        }
        constructList(node.left, nums);
        nums.add(node.val);
        constructList(node.right, nums);
    }
}