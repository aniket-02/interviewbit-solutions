public class Solution {
    public int perfectPeak(ArrayList<Integer> A) {
        int n = A.size();
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        
        leftMax[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A.get(i));
        }
        
        rightMin[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], A.get(i));
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (A.get(i) > leftMax[i - 1] && A.get(i) < rightMin[i + 1]) {
                return 1;
            }
        }
        
        return 0;
    }
}
