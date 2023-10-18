import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        
        List<Integer> a = IntStream.range(0, n)
            .mapToObj(index -> A.get(index) + index)
            .collect(Collectors.toList());

        List<Integer> b = IntStream.range(0, n)
            .mapToObj(index -> A.get(index) - index)
            .collect(Collectors.toList());
            
        int maxA = a.stream().mapToInt(Integer::intValue).max().orElse(0);
        int minA = a.stream().mapToInt(Integer::intValue).min().orElse(0);
        int maxB = b.stream().mapToInt(Integer::intValue).max().orElse(0);
        int minB = b.stream().mapToInt(Integer::intValue).min().orElse(0);
        
        return Math.max(maxA - minA, maxB - minB);
    }
}
