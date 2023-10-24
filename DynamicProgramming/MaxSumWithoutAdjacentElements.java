public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i ++) {
            if (i == 0) {
                dp[i] = Math.max(A.get(0).get(i), A.get(1).get(i));
            } else if (i == 1) {
                dp[i] = Math.max(dp[i - 1], Math.max(A.get(0).get(i), A.get(1).get(i)));
            } else {
                dp[i] = Math.max(dp[i - 1], Math.max(A.get(0).get(i), A.get(1).get(i)) + dp[i - 2]);
            }
        }

        return dp[n - 1];
    }
}
