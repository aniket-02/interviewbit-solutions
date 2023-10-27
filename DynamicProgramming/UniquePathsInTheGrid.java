public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();

        int[][] dp = new int[m][n];
        
        dp[0][0] = (A.get(0).get(0) == 0) ? 1 : 0;

        for (int j = 1; j < n; j++) {
            dp[0][j] = (A.get(0).get(j) == 0) ? dp[0][j - 1] : 0;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = (A.get(i).get(0) == 0) ? dp[i - 1][0] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.get(i).get(j) == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
