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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        while(!levels.isEmpty()){
            int levelsize = levels.size();
            double sum=0;
            int nodes=0;
            for(int i=0; i<levelsize; i++){
                TreeNode node = levels.poll();
                sum += node.val;
                nodes++;
                if(node.left != null){
                    levels.add(node.left);
                }
                if(node.right != null){
                    levels.add(node.right);
                }
            }
            res.add(sum/nodes);
        }
        return res;
    }
}