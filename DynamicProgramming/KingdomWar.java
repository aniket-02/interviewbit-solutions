public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = A.get(n - 1).get(m - 1);

        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = dp[i + 1][m - 1] + A.get(i).get(m - 1);
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = dp[n - 1][j + 1] + A.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = A.get(i).get(j) + dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1];
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        return maxVal;
    }
}
