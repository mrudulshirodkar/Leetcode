class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<bombs.length; i++){
            for(int j=0; j<bombs.length; j++){
                if(i!=j){
                    double x1 = bombs[i][0];
                    double y1 = bombs[i][1];
                    double r1 = bombs[i][2];
                    double x2 = bombs[j][0];
                    double y2 = bombs[j][1];
                    
                    double d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
                
                    if(d <= r1){
                        adj.putIfAbsent(i, new ArrayList<>());
                        adj.get(i).add(j);
                    }
                }
                
                
                
            }
        }
        
        int maxCount = 0;
        for(int i=0; i<bombs.length; i++){
            HashSet<Integer> set = new HashSet<>();
            maxCount = Math.max(maxCount, dfs(i, adj, set));
        }
        
        return maxCount;
    }
    private int dfs(int start, Map<Integer, List<Integer>> adj, HashSet<Integer> set){
        set.add(start);
        if(adj.containsKey(start)){
            for(int neighbor: adj.get(start)){
                if(!set.contains(neighbor)){
                    dfs(neighbor, adj, set);
                }
            }
        }
        
        return set.size();
    }
}