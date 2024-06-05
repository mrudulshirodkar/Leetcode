class Solution {
    int min = 0;
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int [] current = q.poll();
                for(int[] d: dir){
                    int r = current[0] + d[0];
                    int c = current[1] + d[1];
                
                    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] != 1){
                    continue;
                    }
                    q.add(new int[]{r,c});
                    fresh--;
                    grid[r][c] = 2;
                }
            }
            min += 1;
        }
        
        if(fresh > 0){
            return -1;
        }else return min;
    }
    
}