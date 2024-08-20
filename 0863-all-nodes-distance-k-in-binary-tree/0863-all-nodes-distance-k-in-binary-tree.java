/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        markParents(root, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(target, true);
        int currDist = 0;
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            if(currDist == k) break;
            currDist++;
            for(int i=0; i<qSize; i++){
                TreeNode node = queue.poll();
                if(node.left != null && visitedMap.get(node.left) == null){
                    queue.offer(node.left);
                    visitedMap.put(node.left, true);
                }
                if(node.right != null && visitedMap.get(node.right) == null){
                    queue.offer(node.right);
                    visitedMap.put(node.right, true);
                }
                if(map.get(node) != null && visitedMap.get(map.get(node)) == null){
                    queue.offer(map.get(node));
                    visitedMap.put(map.get(node), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
        }
        return result;
        
    }
    
    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            for(int i=0; i<qSize; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    map.put(node.left, node);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    map.put(node.right, node);
                }
            }
        }
    }
}