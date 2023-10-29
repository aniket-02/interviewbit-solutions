public class Solution {
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }
}
