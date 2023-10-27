public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];

        dp[0][0] = A.get(0).get(0);

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + A.get(0).get(j);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + A.get(i).get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + A.get(i).get(j);
            }
        }

        return dp[n - 1][m - 1];
    }
}
