public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = A.get(0).get(i);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = A.get(i).get(0);
        }

        int maxVal = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        return maxVal*maxVal;
    }
}
