public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        
        if (n == 0)
            return 0;
        
        int m = A.get(0).size();
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = A.get(i).get(j) + (i == 0 ? 0 : dp[i-1][j]);
            }
        }
        
        int count = 0;
        
        for(int row1 = 0; row1 < n; row1++) {
            for(int row2 = row1; row2 < n; row2++) {
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int totalSum = 0;
                
                for (int j = 0; j < m; j++) {
                    totalSum += dp[row2][j] - (row1 == 0 ? 0 : dp[row1-1][j]);
                    int sumCount = map.getOrDefault(totalSum,0);
                    count += sumCount;
                    map.put(totalSum, sumCount + 1);
                }
            }
        }
        return count;
    }
}
