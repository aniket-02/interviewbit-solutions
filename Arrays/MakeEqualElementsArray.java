import java.util.stream.IntStream;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int min = A.stream()
            .mapToInt(Integer::intValue)
            .min()
            .orElse(0);

        int number = min + B;

        for (int i = 0; i < n; i ++) {
            if (!(A.get(i) == number || A.get(i) + B == number || A.get(i) - B == number)) {
                return 0;
            }
        }

        return 1;
    }
}
