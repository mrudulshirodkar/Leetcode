class Solution {
    public int numIslands(char[][] grid) {
        int no_of_islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    no_of_islands ++;
                    dfs(grid, i, j);
                }
            }
        }
        return no_of_islands;
    }
    private void dfs(char[][] grid, int x, int y){
        if(x<0 || y<0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        
        dfs(grid, x+1, y);
        dfs(grid, x, y+1);
        dfs(grid, x-1, y);
        dfs(grid, x, y-1);
    }
}