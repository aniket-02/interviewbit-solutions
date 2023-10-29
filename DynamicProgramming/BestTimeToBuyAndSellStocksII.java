public class Solution {
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        int profit = 0;
        
        for(int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i-1)) {
                profit += (A.get(i) - A.get(i-1));
            }
        }
    
        return profit;
    }
}
