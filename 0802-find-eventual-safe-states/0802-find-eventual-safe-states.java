class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> safe = new HashMap<>();
        for(int i=0; i<graph.length; i++){
            if(dfs(graph, i, safe)){
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean dfs(int[][] graph, int current, HashMap<Integer, Boolean> safe){
        if(safe.containsKey(current)){
            return safe.get(current);
        }
        
        safe.put(current, false);
        for(int neighbor: graph[current]){
            if(!dfs(graph, neighbor, safe)){
                return false;
            }
        }
        
        safe.put(current, true);
        return true;
    }
}