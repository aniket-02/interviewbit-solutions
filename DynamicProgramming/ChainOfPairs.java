public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j).get(1) < A.get(i).get(0) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}
