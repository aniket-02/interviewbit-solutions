public class Solution {
    private int getStableCost(int[] horses, int start, int end) {
        int whiteHorses = 0;
        int blackHorses = 0;

        for (int i = start; i <= end; i++) {
            if (horses[i] == 0) {
                whiteHorses++;
            } else {
                blackHorses++;
            }
        }

        return whiteHorses * blackHorses;
    }

    private int findMinSumOfProducts(int[] horses, int K) {
        int n = horses.length;

        int[][] dp = new int[K + 1][n + 1];

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i] = getStableCost(horses, 0, i - 1);
        }

        for (int i = 2; i <= K; i++) {
            for (int j = i; j <= n; j++) {
                for (int x = i - 1; x < j; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + getStableCost(horses, x, j - 1));
                }
            }
        }

        if (dp[K][n] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[K][n];
    }

    public int arrange(String A, int B) {
        int n = A.length();
        int[] horses = new int[n];
        for (int i = 0; i < n; i++) {
            horses[i] = (A.charAt(i) == 'W') ? 0 : 1;
        }

        return findMinSumOfProducts(horses, B);
    }
}
