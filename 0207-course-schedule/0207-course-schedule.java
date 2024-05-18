class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>adj[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] prerequisite:prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
        for(int i=0; i< numCourses; i++) {
           if(!isCyclic(adj, visited, i)) {
             return false;
         } 
        }
        return true;
    }
    
    boolean isCyclic(ArrayList<Integer>adj[], int[] visited, int src) {
        if(visited[src] == 1) {
            return false;
        }
        if(visited[src] == 2) {
            return true;
        }
        visited[src] = 1;
        for(Integer neighbour: adj[src]) {
            if(!isCyclic(adj, visited, neighbour)) {
                return false;
            }
        }
        visited[src] = 2;
        return true;
    }
}