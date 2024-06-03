class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        Map<Integer, Boolean> memoisationMap = new HashMap<>();
       
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<graph.length; i++){
            boolean res = dfs(i, graph, memoisationMap, visited);
            memoisationMap.put(i, res);
        }
        
        for(int i=0; i<memoisationMap.size(); i++){
            if(memoisationMap.get(i)){
                safe.add(i);
            }
        }
        return safe;
    }
    
    private boolean dfs(int current, int[][] graph, Map<Integer, 
                        Boolean> memoisationMap, Set<Integer> visited){
        
        if(memoisationMap.containsKey(current)){
            return memoisationMap.get(current);
        }
        
        if(visited.contains(current)){
            return false;
        }
        
        memoisationMap.put(current, false);
        visited.add(current);
        for(int neighbor: graph[current]){
            if (!dfs(neighbor, graph, memoisationMap, visited)) {
                return false;
            }
        }
        
        visited.remove(current);
        memoisationMap.put(current, true);
        return true;
    }
}