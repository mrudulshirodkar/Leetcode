class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<cols; i++){
            if(board[0][i] == 'O'){
                dfs(0, i, board);
            }
            if(board[rows-1][i] == 'O'){
                dfs(rows-1, i, board);
            }
        }
        
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }
            if(board[i][cols-1] == 'O'){
                dfs(i, cols-1, board);
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 't'){
                    board[i][j] = 'O';
                }
            }
        }
        
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board[0].length; j++){
        //         if(board[i][j] == 't'){
        //             board[i][j] = 'x';
        //         }
        //     }
        // }
        
    }
    int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int x, int y, char[][] board){
        if(x>=board.length || y>=board[0].length || x<0 || y<0){
            return;
        }
        if(board[x][y] == 'O'){
            board[x][y] = 't';
            for(int[] d: dir){
                dfs(x+d[0], y+d[1], board);
            }
        }
    }
}