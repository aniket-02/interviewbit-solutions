public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        A.sort(null);
        
        int n = A.size();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            result = Math.min(result, A.get(i) ^ A.get(i + 1));
        }

        return result;
    }
}
