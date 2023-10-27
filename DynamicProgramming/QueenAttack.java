public class Solution {
    public boolean inLimits(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;    
    }
    
    public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> queens) {
        int n = queens.size();
        int m = queens.get(0).length();
        
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = queens.get(i).charAt(j) - '0';
            }
        }

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        while (inLimits(x, y, n, m)) {
                            result[x][y]++;
                            if (board[x][y] == 1) {
                                break;
                            }
                            x += dir[0];
                            y += dir[1];
                        }
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                rowList.add(result[i][j]);
            }
            resultList.add(rowList);
        }

        return resultList;
    }
}
