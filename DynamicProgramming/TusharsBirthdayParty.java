public class Solution {
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int m = B.size();
        int maxA = A.stream().mapToInt(Integer::intValue).max().orElse(0);

        long[] dp = new long[maxA + 1];
        for (int i = 1; i <= maxA; i++) {
            dp[i] = Long.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i <= maxA; i++) {
            for (int j = 0; j < m; j++) {
                if (B.get(j) <= i) {
                    dp[i] = Math.min(dp[i], dp[i - B.get(j)] + C.get(j));
                }
            }
        }

        long result = 0;
        for (int a : A) {
            result += dp[a];
        }

        return (int) (result % 1000000007);
    }
}
