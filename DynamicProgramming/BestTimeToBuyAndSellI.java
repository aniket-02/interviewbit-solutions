public class Solution {
    public int maxProfit(final List<Integer> A) {
        int n = A.size();

        if (n <= 1) {
            return 0;
        }

        int buy = A.get(0);
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            int current = A.get(i);
            if (current < buy) {
                buy = current;
            } else if (current - buy > maxProfit) {
                maxProfit = current - buy;
            }
        }

        return maxProfit;
    }
}
