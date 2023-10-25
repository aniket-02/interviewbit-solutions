public class Solution {
    public int chordCnt(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i ++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j ++) {
                catalan[i] = (catalan[i] + (catalan[j] * catalan[i - j - 1])) % 1000000007;
            }
        }

        return (int)(catalan[n] % 1000000007);
    }
}
