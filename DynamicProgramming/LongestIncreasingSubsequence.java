public class Solution {
    public int lis(final List<Integer> A) {
        int n = A.size();
        int[] lis = new int[n];
        
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (A.get(j) < A.get(i) && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        
        for (int i = 0; i < n; i ++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }
}
