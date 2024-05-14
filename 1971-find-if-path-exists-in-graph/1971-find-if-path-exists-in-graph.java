class Solution {
    boolean flag = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList());
        }
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n]; 
        dfs(map, visited, source, destination);
        return flag;
    }
    
    public void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int start, int end){
        visited[start] = true;
        for(int neighbor: map.get(start)){
            if(neighbor == end){
                flag = true;
                break;
            }
            
            if(!visited[neighbor]){
                dfs(map, visited, neighbor, end);
            }
        }
    }
}