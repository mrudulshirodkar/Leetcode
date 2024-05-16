class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(visited, isConnected, i);
                count ++;
            }
        }
        return count;
    }
    
    private void dfs(boolean[] visited, int[][] isConnected, int start){
        
        for(int j=0; j<isConnected.length; j++){
            if(!visited[j] && isConnected[start][j] == 1){
                visited[j] = true;
                dfs(visited, isConnected, j);
            }
        }
    }
}