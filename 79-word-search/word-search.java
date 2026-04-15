class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtrack(0,i,j,word,board)) return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int idx,int row,int col,String s,char[][] board){
        if(board[row][col] != s.charAt(idx)) return false;
        if (idx == s.length() - 1) return true;
        char temp = board[row][col];
        board[row][col] = '$'; //marks as visited

        for(int i=0;i<4;i++){
            int nrow = row + dr[i]; 
            int ncol = col + dc[i];
            if(nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && board[nrow][ncol] != '$'){
                if(backtrack(idx+1,nrow,ncol,s,board)) return true;
            }
        }

        board[row][col] = temp; //backtrack
        return false;
    }
}