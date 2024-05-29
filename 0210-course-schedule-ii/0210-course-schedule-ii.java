class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        boolean flag = false;
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
                flag = dfs(adj, visited, i);
            }
            
            if(!flag){
                return new int[]{};
            }
        }
        int j=0;
        for(int i=numCourses-1; i>=0; i--){
            res[j] = resList.get(i);
            j++;
        }
        return res;
        
    }
    ArrayList<Integer> resList = new ArrayList<>();
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
        resList.add(start);
        return true;
    }
}