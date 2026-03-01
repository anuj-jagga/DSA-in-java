class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        int n = board.length;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {

                if(board[r][c] == '.') {

                    for(char ch = '1'; ch <= '9'; ch++) {

                        if(isValid(r, c, board, ch)) {

                            board[r][c] = ch;

                            if(solve(board))
                                return true;

                            board[r][c] = '.';
                        }
                    }

                    return false; // no number fits
                }
            }
        }

        return true; // solved
    }

    boolean isValid(int r, int c, char[][] board, char ch) {

        for(int i = 0; i < 9; i++) {
            if(board[r][i] == ch) return false;
            if(board[i][c] == ch) return false;
        }

        int startRow = r - r % 3;
        int startCol = c - c % 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[startRow + i][startCol + j] == ch)
                    return false;
            }
        }

        return true;
    }
}