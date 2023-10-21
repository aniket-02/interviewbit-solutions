import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<Integer> sortedA = A.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortedB = B.stream()
                .sorted()
                .collect(Collectors.toList());

        int maxTime = IntStream.range(0, A.size())
                .map(i -> Math.abs(sortedA.get(i) - sortedB.get(i)))
                .max()
                .getAsInt();

        return maxTime;
    }
}
