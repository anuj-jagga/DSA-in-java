class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] board = new int[n][n];
        backtrack(0,board);
        return res;
    }

    void backtrack(int row,int[][] board){
        int n = board.length;
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                String st = "";
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){
                        st += "Q";
                    }else{
                        st += ".";
                    }
                }
                temp.add(st);
            }
            res.add(temp);
            return;
        }

        for(int col = 0;col < n; col++){
            if(isSafe(row,col,board)){
                board[row][col] = 1;
                backtrack(row+1,board);
                board[row][col] = 0;
            }
        }
    }

    boolean isSafe(int r,int c, int[][] board){
        int n = board.length;

        for(int i=0;i<n;i++){
            if(board[i][c] == 1) return false;
        }

        for(int i = 1; i<= Math.min(r,c);i++){
            if(board[r-i][c-i] == 1) return false;
        }

        for(int i=1;i<= Math.min(r,n-1-c);i++){
            if(board[r-i][c+i] == 1) return false;
        }

        return true;
    }
}