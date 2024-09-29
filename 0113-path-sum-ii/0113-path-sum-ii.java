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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        traverse(root, targetSum, new ArrayList<>());
        return res;
    }
    public void traverse(TreeNode node, int targetSum, ArrayList<Integer> path){
        targetSum -= node.val;
        path.add(node.val);
        if(node.left == null && node.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }else{
            if(node.left != null){
                traverse(node.left, targetSum, path);
            }
            if(node.right != null){
                traverse(node.right, targetSum, path);
            }
        }
        path.remove(path.size()-1);
    }
}