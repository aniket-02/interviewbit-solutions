import java.util.stream.IntStream;

public class Solution {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        Set<Integer> hSet = new HashSet<>(A);

        long b = (long) ((n * (n + 1L)) / 2L) - hSet.stream()
                .mapToLong(Integer::intValue)
                .sum();

        int a = IntStream.range(1, n + 1).reduce(0, (x, y) -> x ^ y);
        a = A.stream().reduce(a, (x, y) -> x ^ y);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(a ^ (int) b);
        result.add((int) b);

        return result;
    }
}
