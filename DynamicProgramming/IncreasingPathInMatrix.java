public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();

        if (n == 0) {
            return -1;
        }

        int m = A.get(0).size();
        boolean[][] dp = new boolean[n][m];

        dp[0][0] = true;

        for (int i = 1; i < m; i++) {
            if (A.get(0).get(i) > A.get(0).get(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (A.get(i).get(0) > A.get(i - 1).get(0) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ((A.get(i - 1).get(j) < A.get(i).get(j) && dp[i - 1][j]) ||
                    (A.get(i).get(j - 1) < A.get(i).get(j) && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        if (dp[n - 1][m - 1]) {
            return n + m - 1;
        }

        return -1;
    }
}
