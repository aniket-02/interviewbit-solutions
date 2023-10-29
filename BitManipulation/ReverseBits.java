public class Solution {
	public long reverse(long a) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1L << i)) != 0) {
                result ^= (1L << (31 - i));
            }
        }
        return result;
	}
}
