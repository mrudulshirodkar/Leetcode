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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list1 = new ArrayList<>();
        if(root==null){
            return list1;
        }
        
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        
        while(!levels.isEmpty()){
            ArrayList<Integer> list2 = new ArrayList<>();
            int levelsize = levels.size();
            
            for(int i=0; i<levelsize; i++){
                TreeNode node = levels.poll();
                list2.add(node.val);
                
                if(node.left != null){
                    levels.add(node.left);
                }
                if(node.right != null){
                    levels.add(node.right);
                }
            }
            list1.add(list2);
        }
        return list1;
    }
}