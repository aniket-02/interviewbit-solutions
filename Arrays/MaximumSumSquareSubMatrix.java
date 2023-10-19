public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + A.get(i - 1).get(0);
        }
        for (int j = 1; j <= m; j++) {
            dp[1][j] = dp[1][j - 1] + A.get(0).get(j - 1);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = A.get(i - 1).get(j - 1) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (i + B - 1 <= n) {
                for (int j = 1; j <= m; j++) {
                    if (j + B - 1 <= m) {
                        int t = dp[i + B - 1][j + B - 1] - dp[i - 1][j + B - 1] - dp[i + B - 1][j - 1] + dp[i - 1][j - 1];
                        result = Math.max(result, t);
                    }
                }
            }
        }
        
        return result;
    }
}
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + A.get(i - 1).get(0);
        }
        for (int j = 1; j <= m; j++) {
            dp[1][j] = dp[1][j - 1] + A.get(0).get(j - 1);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = A.get(i - 1).get(j - 1) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (i + B - 1 <= n) {
                for (int j = 1; j <= m; j++) {
                    if (j + B - 1 <= m) {
                        int t = dp[i + B - 1][j + B - 1] - dp[i - 1][j + B - 1] - dp[i + B - 1][j - 1] + dp[i - 1][j - 1];
                        result = Math.max(result, t);
                    }
                }
            }
        }
        
        return result;
    }
}
