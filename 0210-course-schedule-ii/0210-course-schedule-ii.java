class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      
        ArrayList<Integer> [] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int []prereq : prerequisites){
            adj[prereq[1]].add(prereq[0]);
        }
        
        int[] visited = new int[numCourses];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<numCourses; i++){
            if (visited[i] == 0){
                if(!cyclic(visited, adj, i, stk))
                return new int[0];
            }
        }
        // cyclic(visited, adj, 0, stk);
        int[] res = new int[numCourses];
        int index = 0;
        while (!stk.isEmpty()) {
            res[index++] = stk.pop();
        }
        // for(int i=0; i<numCourses; i++){
        //     res[i] = stk.pop();
        // }
        return res;
    }
    
    public boolean cyclic(int[] visited, ArrayList<Integer> [] adj, 
                          int start, Stack<Integer> stk){
        if(visited[start] == 1){
            return false;
        }
        if(visited[start] == 2){
            return true;
        }
        visited[start] = 1;
        for(int neighbor: adj[start]){
            if(!cyclic(visited, adj, neighbor, stk)){
                return false;
            }
        }
        visited[start] = 2;
        stk.push(start);
        return true;
        
    }
}