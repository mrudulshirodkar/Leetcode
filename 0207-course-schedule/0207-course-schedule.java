class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean res = false;
        ArrayList<Integer> [] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] preq : prerequisites){
            adj[preq[1]].add(preq[0]);
        }
        
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0){
                res = dfs(adj, visited, i);
            }
            
            if(!res){
                return false;
            }
        }
        
        return res;
        
    }
    
    public boolean dfs(ArrayList<Integer> [] adj, int[] visited, int start){
        if(visited[start] == 1) return false;
        if(visited[start] == 2) return true;
        
        visited[start] = 1;
        for(int neigh: adj[start]){
            if(!dfs(adj, visited, neigh)){
                return false;
            }
        }
        
        visited[start] = 2;
        return true;
    }
}