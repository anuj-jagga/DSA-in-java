class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j =0; j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void dfs(int row,int col, char[][] grid){
        vis[row][col] = true;

        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow >= 0 && ncol >=0 && nrow <grid.length && ncol < grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                dfs(nrow,ncol,grid);
            }
        }
    }
}