class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> [] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] pre: prerequisites){
            adj[pre[1]].add(pre[0]);
        }
        
        int[] visited = new int [numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!isCyclic(visited, adj, i))
                return false;
        }
        
        return true;
    }
    
    boolean isCyclic(int[] visited, ArrayList<Integer> [] adj, int start){
        if(visited[start] == 1){
            return false;
        }
        if(visited[start] == 2){
            return true;
        }
        
        visited[start] = 1;
        for(int neighbor: adj[start]){
            if(!isCyclic(visited, adj, neighbor))
                return false;
        }
        visited[start] = 2;
        return true;
    }
}