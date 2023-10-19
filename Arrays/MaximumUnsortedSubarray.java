public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        
        int left = 0;
        while (left < n - 1 && A.get(left) <= A.get(left + 1)) {
            left++;
        }
        
        if (left == n - 1) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        
        int right = n - 1;
        while (right > 0 && A.get(right) >= A.get(right - 1)) {
            right--;
        }
        
        int minUnsorted = Integer.MAX_VALUE;
        int maxUnsorted = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            minUnsorted = Math.min(minUnsorted, A.get(i));
            maxUnsorted = Math.max(maxUnsorted, A.get(i));
        }

        while (left > 0 && A.get(left - 1) > minUnsorted) {
            left--;
        }

        while (right < n - 1 && A.get(right + 1) < maxUnsorted) {
            right++;
        }

        return new ArrayList<>(Arrays.asList(left, right));
    }
}
