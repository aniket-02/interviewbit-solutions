public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();

        if (n == 1) {
            return A.get(0) == 1 ? 2 : 1;
        }
        
        boolean[] present = new boolean[A.stream().mapToInt(Integer::intValue).max().orElse(0) + 1];
        
        for (int i : A) {
            if (i > 0) {
                present[i] = true;
            }
        }
        
        int result = 0;
        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                result = i;
                break;
            }
        }

        return result == 0 ? (A.stream().mapToInt(Integer::intValue).max().orElse(0) + 1) : result;
    }
}
