public class Solution {
    private boolean dfs(char[][] board, String word, int pos, int row, int col) {
        if (pos >= word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(pos)) {
            return false;
        }

        int[] rowOffsets = {0, -1, 0, 1};
        int[] colOffsets = {-1, 0, 1, 0};

        for (int k = 0; k < 4; k++) {
            int newRow = row + rowOffsets[k];
            int newCol = col + colOffsets[k];
            if (dfs(board, word, pos + 1, newRow, newCol)) {
                return true;
            }
        }

        return false;
    }
    
    public int exist(ArrayList<String> A, String B) {
        int n = A.size();
        int m = A.get(0).length();
        
        char[][] board = new char[n][m];

        for (int i = 0; i < n; i ++) {
            board[i] = A.get(i).toCharArray();
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == B.charAt(0) && dfs(board, B, 0, i, j)) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
