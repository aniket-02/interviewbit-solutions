public class Solution {
    public int maxProduct(final List<Integer> A) {
        int n = A.size();
        int maxEndingHere = A.get(0);
        int minEndingHere = A.get(0);
        int maxSoFar = A.get(0);

        for (int i = 1; i < n; i++) {
            int current = A.get(i);
            int temp = Math.max(current, Math.max(current * maxEndingHere, current * minEndingHere));
            minEndingHere = Math.min(current, Math.min(current * maxEndingHere, current * minEndingHere));
            maxEndingHere = temp;
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
