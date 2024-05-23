class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col-1, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i=0; i<col; i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row-1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
    
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean){
        if(i>=heights.length || j>=heights[0].length || i<0 || j<0){
            return;
        }
        if(prev > heights[i][j] || ocean[i][j]) return;
        ocean[i][j] = true;
        
        for(int[] d : dir){
             dfs(heights, i+d[0], j+d[1], heights[i][j], ocean);
        }
    }
}