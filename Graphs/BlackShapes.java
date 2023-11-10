public class Solution {
    private boolean inLimits(int i, int j, int n, int m) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }

    private void dfs(ArrayList<String> A, boolean[][] visited, int i, int j, int n, int m, int[][] moves) {
        visited[i][j] = true;

        for (int[] move : moves) {
            int _i = i + move[0];
            int _j = j + move[1];
            if (inLimits(_i, _j, n, m) && A.get(_i).charAt(_j) == 'X' && !visited[_i][_j]) {
                dfs(A, visited, _i, _j, n, m, moves);
            }
        }
    }

    public int black(ArrayList<String> A) {
        int n = A.size();
        int m = A.get(0).length();
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(A, visited, i, j, n, m, moves);
                    count++;
                }
            }
        }
        return count;
    }
}
