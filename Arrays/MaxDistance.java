import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Solution {
    public int maximumGap(final List<Integer> A) {
        List<int[]> indexedArray = IntStream.range(0, A.size())
                .mapToObj(i -> new int[]{A.get(i), i})
                .sorted(Comparator.comparingInt(x -> x[0]))
                .collect(Collectors.toList());
                
        int minIndex = A.size();
        int result = 0;

        for (int i = 0; i < A.size(); i++) {
            if (indexedArray.get(i)[1] < minIndex) {
                minIndex = indexedArray.get(i)[1];
            }
            result = Math.max(result, indexedArray.get(i)[1] - minIndex);
        }

        return result;
    }
}
