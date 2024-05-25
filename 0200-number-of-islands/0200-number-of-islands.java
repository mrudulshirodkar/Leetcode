class Solution {
    public int numIslands(char[][] grid) {
       int no_of_islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    no_of_islands ++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return no_of_islands;
    }
    private void bfs(char[][] grid, int x, int y){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] curent = q.poll();
            for(int[] d: dir){
                int r = curent[0] + d[0];
                int c = curent[1] + d[1];
                
                if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0'){
                    continue;
                }
                
                q.add(new int[]{r,c});
                grid[r][c] = '0';
            }
        }
    }
}