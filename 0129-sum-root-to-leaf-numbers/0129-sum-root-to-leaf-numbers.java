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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Stack<TreeNode> stk = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        stk.push(root);
        pathStack.push(String.valueOf(root.val));
        
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            String path = pathStack.pop();
            
            if(node.left == null && node.right == null){
                sum += Integer.parseInt(path);
            }
            if(node.left != null){
                stk.push(node.left);
                pathStack.push(String.valueOf(path + node.left.val));
            }
            if(node.right != null){
                stk.push(node.right);
                pathStack.push(String.valueOf(path + node.right.val));
            }
        }
        
        return sum;
        
    }
}