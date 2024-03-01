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
       Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        levels.add(null);
        
        ArrayList<Double> avglist = new ArrayList<>();
        while(levels.peek()!=null){
            double sum = 0;
            int nodes = 0;
            while(levels.peek()!=null){
                TreeNode node = levels.poll();
                sum+=node.val;
                nodes++;
                if(node.left!=null) levels.add(node.left);
                if(node.right!= null) levels.add(node.right);
                
            }
            levels.add(levels.poll());
            avglist.add(sum/nodes);
        }
        
        return avglist;
    }
}