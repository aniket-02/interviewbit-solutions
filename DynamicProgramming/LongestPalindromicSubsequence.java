public class Solution {
    public int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
