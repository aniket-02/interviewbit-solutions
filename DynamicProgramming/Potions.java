public class Solution {
    public int minSmoke(ArrayList<Integer> A) {
        int n = A.size();
        int[][] smoke = new int[n][n];
        int[][] color = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            color[i][i] = A.get(i);            
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                smoke[i][j] = Integer.MAX_VALUE;
                color[i][j] = 0;

                for (int k = i; k < j; k++) {
                    int s = smoke[i][k] + smoke[k + 1][j] + color[i][k] * color[k + 1][j];
                    if (s < smoke[i][j]) {
                        smoke[i][j] = s;
                        color[i][j] = (color[i][k] + color[k + 1][j]) % 100;
                    }
                }
            }
        }
        
        return smoke[0][n-1];
    }
}
