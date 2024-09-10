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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator small = new BSTIterator(root, false);
        BSTIterator big = new BSTIterator(root, true);
        
        int i = small.next();
        int j = big.next();
        
        while(i<j){
            if(i+j == k) return true;
            if(i+j < k){
                i = small.next();
            }
            if(i+j > k){
                j = big.next();
            }
        }
        
        return false;
    }
}

class BSTIterator{
    private Stack<TreeNode> stk = new Stack<>();
    private boolean reverse = true;
    
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    
    
    
    // public boolean hasNext(){
    //     return !stk.isEmpty();
    // }
    
    public int next(){
        TreeNode temp = stk.pop();
        if(!reverse){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    } 
    
    public void pushAll(TreeNode node){
        while(node!=null){
            stk.push(node);
            if(!reverse){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        
    }
} 


