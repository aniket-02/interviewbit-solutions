public class Solution {
    public int solve(List<Integer> A) {
        int max = A.stream().max(Integer::compare).orElse(0);
        int min = A.stream().min(Integer::compare).orElse(0);
        return max + min;
    }
}
