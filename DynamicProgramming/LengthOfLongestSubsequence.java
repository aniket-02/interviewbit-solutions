public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }
        
        for (int i = n-2; i >= 0; i --) {
            for (int j = n-1; j > i; j --) {
                if (A.get(i) > A.get(j) && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }
        
        int maximum = 0;

        for (int i = 0; i < n; i++) {
            if (left[i] + right[i] - 1 > maximum) {
                maximum = left[i] + right[i] - 1;
            }
        }

        return maximum;
    }
}
