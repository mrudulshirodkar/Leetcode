class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int count = dfs(i, j, grid);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    
    public int dfs(int i, int j, int[][] grid){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        
        
        count += dfs(i, j+1, grid);
        count += dfs(i, j-1, grid);
        count += dfs(i+1, j, grid);
        count += dfs(i-1, j, grid);
        
        return count;
    }
}