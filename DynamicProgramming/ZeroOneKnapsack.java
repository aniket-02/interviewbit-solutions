public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();
        int[][] dp = new int[n + 1][C + 1];
        
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= C; j ++) {
                if (B.get(i - 1) <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], A.get(i-1) + dp[i-1][j - B.get(i-1)]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][C];
    }
}
