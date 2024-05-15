class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited, rooms, 0);
        for(boolean roomVisited: visited){
            if(!roomVisited){
                return false;
            }
        }
        return true;
        // for(int i=0; i<rooms.size(); i++){
        //     if(visited[i]){
        //         return true;
        //     }
        // }
        // return false;
    }
    private void dfs(boolean[] visited, List<List<Integer>> rooms, int start){
        visited[start] = true;
        for(int neighbor: rooms.get(start)){
            if(!visited[neighbor]){
                dfs(visited, rooms, neighbor);
            }
        }
        
    }
}