public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        
        if (n != m) {
            return 0;
        }

        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j][1] = true;
                }
            }
        }
        
        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i <= n - len; i ++) {
                for (int j = 0; j <= n - len; j ++) {
                    for (int k = 1; k < len; k ++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][len - k]) || 
                            (dp[i][j + len - k][k] && dp[i + k][j][len - k])) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        if (dp[0][0][n]) {
            return 1;
        }
        return 0;
    }
}
