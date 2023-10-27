public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();

        int[][] dp = new int[n][n];

        if (n == 1) {
            return A.get(0).get(0);
        }
        
        if (n == 2) {
            return A.get(0).get(0) + Math.min(A.get(1).get(0), A.get(1).get(1));
        }

        dp[0][0] = A.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + A.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + A.get(i).get(i);
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + A.get(i).get(j);
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        
        for (int j = 0; j < n; j ++) {
            if (dp[n-1][j] < minVal) {
                minVal = dp[n-1][j];
            }
        }
        return minVal;
	}
}
