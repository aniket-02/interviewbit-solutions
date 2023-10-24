public class Solution {  
    private boolean isValidMove(ArrayList<ArrayList<Character>> A, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (A.get(row).get(i) == c || A.get(i).get(col) == c) {
                return false;
            }
        }

        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (A.get(i + boxStartRow).get(j + boxStartCol) == c) {
                    return false;
                }
            }
        }

        return true;
    }
    
    private boolean solveSudokuUtil(ArrayList<ArrayList<Character>> A) {
        int n = A.size();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (A.get(row).get(col) == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidMove(A, row, col, c)) {
                            A.get(row).set(col, c);

                            if (solveSudokuUtil(A)) {
                                return true;
                            }

                            A.get(row).set(col, '.');
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
	public void solveSudoku(ArrayList<ArrayList<Character>> A) {        
        solveSudokuUtil(A);
	}
}
