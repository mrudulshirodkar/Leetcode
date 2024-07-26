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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            
            for(int i=0; i<qSize; i++){
                TreeNode node = queue.poll();
                if(flag){
                    levelList.add(node.val);
                }else{
                    levelList.add(0, node.val);
                }
                if(node.left != null){
                        queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                
            }
            flag = !flag;
            result.add(levelList);
        }
        
        return result;
    }
}