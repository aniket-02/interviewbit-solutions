import java.util.stream.Collectors;

public class Solution {
	public int repeatedNumber(final List<Integer> A) {
        Map<Integer, Long> frequencyMap = A.stream()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        int n = A.size();
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                return entry.getKey();
            }
        }
        
        return -1;
	}
}
