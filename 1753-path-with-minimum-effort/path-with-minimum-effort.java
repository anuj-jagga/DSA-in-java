class Solution {
    class Pair{
        int d;
        int r;
        int c;

        Pair(int dist,int row,int col){
            d = dist;
            r = row;
            c = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] a : dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        dist[0][0] = 0; //src

        int destRow = n-1;
        int destCol = m-1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.d - y.d);
        pq.add(new Pair(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.r;
            int col = curr.c;
            int d = curr.d;

            if(row == destRow && col == destCol){
                return d;
            }

            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int effort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col]), dist[row][col]); // max in path

                    if(effort < dist[nrow][ncol]){ // min overall
                        pq.add(new Pair(effort,nrow,ncol));
                        dist[nrow][ncol] = effort;
                    }
                }
            } 
        }

        return 0;
    }
}