public class Solution {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    public boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        while (j >= 0 && i < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    
    public void solveNQueensUtil(char[][] board, int A, int col) {
        if (col == A) {
            ArrayList<String> temp = new ArrayList<String>();
            for (char[] row : board) {
                temp.add(String.valueOf(row));
            }
            result.add(temp);
            return;
        }
        
        for (int i = 0; i < A; i ++) {
            if (isSafe(board, i, col, A)) {
                board[i][col] = 'Q';
                solveNQueensUtil(board, A, col + 1);
                board[i][col] = '.';
            }
        }
    }
    
	public ArrayList<ArrayList<String>> solveNQueens(int A) {
        char[][] board = new char[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                board[i][j] = '.';
            }
        }
        
        solveNQueensUtil(board, A, 0);
        return result;
	}
}
