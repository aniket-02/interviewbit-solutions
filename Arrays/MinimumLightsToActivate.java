import java.util.stream.IntStream;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int result = 0;
        int i = 0;

        while (i < n) {
            int nextLight = IntStream.rangeClosed(
                    Math.max(0, i - B + 1),
                    Math.min(n - 1, i + B - 1))
                .filter(j -> A.get(j) == 1)
                .max()
                .orElse(-1);

            if (nextLight == -1) {
                return -1;
            }

            result++;
            i = nextLight + B;
        }

        return result;
    }
}