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
class BSTIterator {

    Stack<TreeNode> stk = new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public int next() {
        TreeNode top = stk.pop();
        push(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
    
    void push(TreeNode node){
        while(node != null){
            stk.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */