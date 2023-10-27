public class Solution {
    public int findDiceSum(int A, int B, int C) {
        int MOD = 1000000007;
        int[][] dp = new int[A + 1][C + 1];
        
        dp[0][0] = 1;

        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 1; k <= B && k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }

        return dp[A][C];
    }
}
