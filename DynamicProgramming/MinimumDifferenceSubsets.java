public class Solution {
    public int solve(ArrayList<Integer> A) {
        int s = 0;
        int n = A.size();

        for (int num : A) {
            s += num;
        }

        boolean[][] dp = new boolean[n + 1][s + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= s; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                dp[i][j] = dp[i - 1][j];
                if (A.get(i - 1) <= j) {
                    dp[i][j] |= dp[i - 1][j - A.get(i - 1)];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for (int j = s / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = s - (2 * j);
                break;
            }
        }

        return diff;
    }
}
