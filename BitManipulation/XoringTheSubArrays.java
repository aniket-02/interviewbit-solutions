public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n % 2 == 0) {
            return 0;
        } else {
            int result = 0;
            for (int i = 0; i < n; i += 2) {
                result ^= A.get(i);
            }
            return result;
        }
    }
}
