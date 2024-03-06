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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        boolean lefttoright = true;
        
         while(!levels.isEmpty()){
             int levelsize = levels.size();
            ArrayList<Integer> samelevel = new ArrayList<>();
            
            for(int i=0; i<levelsize; i++){
                TreeNode node = levels.poll();
                if(lefttoright){
                    samelevel.add(node.val);
                }else{
                    samelevel.add(0, node.val);
                }
                
                if(node.left != null){
                    levels.add(node.left);
                }
                if(node.right != null){
                    levels.add(node.right);
                }
            }
             res.add(samelevel);
             lefttoright = !lefttoright;
         }
        return res;
    }
    
    
    
    
    
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        
        ArrayList<List<Integer>> list1 = new ArrayList<>();
        if(root == null){
            return list1;
        }
        int count = 1;
        while(!levels.isEmpty()){
            int levelsize = levels.size();
            ArrayList<Integer> list2 = new ArrayList<>();
            
            for(int i=0; i<levelsize; i++){
                TreeNode node = levels.poll();
                list2.add(node.val);
                
                if(count%2 == 0){
                    if(node.left != null){
                    levels.add(node.left);
                    }
                    if(node.right != null){
                        levels.add(node.right);
                    }
                    
                }
                
                else if(count%2 != 0){
                    if(node.right != null){
                        levels.add(node.right);
                    }
                    if(node.left != null){
                    levels.add(node.left);
                    }
                   
                }
            }
            count++;
            list1.add(list2);
        }
        return list1;
    }*/
}