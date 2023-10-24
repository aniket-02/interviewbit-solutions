public class Solution {
    public String getPermutation(int A, int B) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            nums.add(i);
        }
       
        List<Integer> fact = new ArrayList<>();
        fact.add(1);
        for (int i = 1; i < A; i++) {
            if (i <= 12) {
                fact.add(i * fact.get(i - 1));
            } else {
                fact.add(Integer.MAX_VALUE);
            }
        }
       
        StringBuilder result = new StringBuilder();
        B--;
        while (A > 0) {
            int idx = B / fact.get(A - 1);
            B %= fact.get(A - 1);
            result.append(nums.get(idx));
            nums.remove(idx);
            A--;
        }
       
        return result.toString();
    }
}
