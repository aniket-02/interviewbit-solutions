import java.util.stream.Collectors;

public class Solution {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        Map<Integer, Long> frequencyMap = A.stream()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        ArrayList<Integer> result = new ArrayList<>();

        List<Integer> keys = frequencyMap.keySet().stream().sorted().collect(Collectors.toList());

        for (int n : keys) {
            result.add(frequencyMap.get(n).intValue());
        }

        return result;
    }
}
