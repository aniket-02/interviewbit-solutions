public class Solution {
    public int singleNumber(final List<Integer> A) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum_ith_bit = 0;
            int bit_pos = (1 << i);

            for (int j : A) {
                if ((j & bit_pos) != 0) {
                    sum_ith_bit++;
                }
            }

            if (sum_ith_bit % 3 != 0) {
                result = result | bit_pos;
            }
        }

        return result;
    }
}
