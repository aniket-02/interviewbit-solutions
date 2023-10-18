public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int result = 0;

        result = A.subList(0, B).stream().mapToInt(Integer::intValue).sum();

        int temp = result;

        for (int i = 0; i < B; i++) {
            temp -= A.get(B - 1 - i);
            temp += A.get(n - 1 - i);
            result = Math.max(result, temp);
        }

        return result;
    }
}