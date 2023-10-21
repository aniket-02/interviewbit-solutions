public class Solution {
    public int bulbs(List<Integer> A) {
        int n = A.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 0 && count % 2 == 1) {
                continue;
            }
            if (A.get(i) == 1 && count % 2 == 0) {
                continue;
            }
            if (A.get(i) == 1 && count % 2 == 1) {
                count++;
                continue;
            }
            if (A.get(i) == 0 && count % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
