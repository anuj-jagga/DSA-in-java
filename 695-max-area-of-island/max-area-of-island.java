class Solution {
    int[] dr = {-1,0,+1,0};
    int[] dc = {0,1,0,-1};

    boolean[][] vis;
    int area ;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1 && !vis[i][j]){
                    area = 0;
                    dfs(i,j,grid);
                }
                ans = Math.max(ans,area);
            }
        }
        return ans;
    }

    void dfs(int r,int c,int[][] grid){
        vis[r][c] = true;
        area++;
        
        for(int i=0;i<4;i++){
            int nrow = r + dr[i];
            int ncol = c + dc[i];

            if(nrow>=0 && ncol >=0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                dfs(nrow,ncol,grid);
            }
        }
    }
}