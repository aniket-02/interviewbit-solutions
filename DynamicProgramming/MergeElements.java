public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n <= 1) {
            return 0;
        }

        int[][] dp = new int[n+1][n+1];
 
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i ++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i - 1);
        }
 
        for (int len = 2; len <= n; len ++) {
            for (int i = 1; i <= n - len + 1; i ++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] +
                            prefixSum[j] - prefixSum[i - 1]);
                }
            }
        }
        
        return dp[1][n];
    }
}
