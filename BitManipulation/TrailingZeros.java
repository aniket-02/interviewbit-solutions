public class Solution {
    public int solve(int A) {
        int count = 0;
        while (A % 2 == 0) {
            A >>= 1;
            count ++;
        }
        return count;
    }
}
