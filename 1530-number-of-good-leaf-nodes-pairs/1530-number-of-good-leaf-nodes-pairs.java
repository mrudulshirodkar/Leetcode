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
    public int countPairs(TreeNode root, int distance) {
        int[] ans = new int[1];
        dfs(root, distance, ans);
        
        return ans[0];
    }
    
    public int[] dfs(TreeNode node, int distance, int[] ans){
        if(node == null) return new int[0];
        
        if(node.left == null && node.right == null) return new int[] {1};
        
        int[] leftDist = dfs(node.left, distance, ans);
        int[] rightDist = dfs(node.right, distance, ans);
        
        for(int ld: leftDist){
            for(int rd: rightDist){
                if(ld + rd <= distance){
                    ans[0]++;
                }
            }
        }
        
        int[] distances = new int[leftDist.length + rightDist.length];
        int index = 0;
        
        for(int ld: leftDist){
            if(ld + 1 < distance){
                distances[index++] = ld + 1;
            }
        }
        for(int rd: rightDist){
            if(rd + 1 < distance){
                distances[index++] = rd + 1;
            }
        }
        
        return Arrays.copyOf(distances, index);
    }
}