public class Solution {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];

        if (A.get(n - 1).get(m - 1) > 0) {
            dp[n - 1][m - 1] = 1;
        } else {
            dp[n - 1][m - 1] = Math.abs(A.get(n - 1).get(m - 1)) + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(1, dp[i + 1][m - 1] - A.get(i).get(m - 1));
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = Math.max(1, dp[n - 1][j + 1] - A.get(n - 1).get(j));
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - A.get(i).get(j), 1);
            }
        }

        return dp[0][0];    
    }
}
