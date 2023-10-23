public class Solution {
    public String fractionToDecimal(int A, int B) {
        if (A == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((A < 0) ^ (B < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) A);
        long den = Math.abs((long) B);

        result.append(num / den);

        if (num % den == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> remainderMap = new HashMap<>();
        long remainder = num % den;

        int index = result.length();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int recurringIndex = remainderMap.get(remainder);
                result.insert(recurringIndex, "(");
                result.append(")");
                break;
            }

            remainderMap.put(remainder, index);
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
            index++;
        }

        return result.toString();
    }
}
