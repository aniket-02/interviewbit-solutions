public class Solution {
    public int divide(int A, int B) {        
        if (B == 0 || (B == -1 && A == Integer.MIN_VALUE)) {
            return Integer.MAX_VALUE;
        }
        
        if (A == B) {
            return 1;
        }
        
        if (B == 1) {
            return A;
        }
        
        if (B == -1) {
            return -A;
        }

        int sign = ((A < 0 && B < 0) || (A >= 0 && B >= 0)) ? 1 : -1;

        long numA = Math.abs((long) A);
        long numB = Math.abs((long) B);

        int answer = (int)Math.floor(Math.exp(Math.log(numA) - Math.log(numB))); 

        if (answer > Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE;
        }
        return sign * answer;
    }
}
