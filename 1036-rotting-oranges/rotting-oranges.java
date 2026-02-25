class Node
{
    int row,col,time;

    Node(int i,int j,int t){
        row = i;
        col = j;
        time = t;
    }
}
class Solution {
    public boolean isValid(int nrow,int ncol, int rows,int cols){
        return (nrow>=0 && ncol>=0 && nrow<rows && ncol<cols);
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i,j,0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int minTime = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            for(int[] dir:dirs){
                int nrow = curr.row + dir[0];
                int ncol = curr.col + dir[1];

                if(isValid(nrow,ncol,rows,cols) && grid[nrow][ncol]==1){
                    q.offer(new Node(nrow,ncol,curr.time+1));
                    grid[nrow][ncol]=2;
                    fresh--;
                    minTime = curr.time+1;
                }
            }
        }
        return fresh == 0? minTime : -1;
    }
}