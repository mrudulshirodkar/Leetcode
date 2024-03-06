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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        while(!queue.isEmpty()){
            int qsize = queue.size();
            int value = Integer.MIN_VALUE;
            for(int i=0; i<qsize; i++){
               TreeNode node = queue.poll();
                // if(qsize == 1){
                //     value = node.val;
                // }else
                {
                    value = Math.max(value, node.val);
                }
                
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(value);
        }
        return res;
    }
}