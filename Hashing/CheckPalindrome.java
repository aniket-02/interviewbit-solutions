import java.util.stream.Collectors;

public class Solution {
    public int solve(String A) {
        Map<Character, Long> charCount = A.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        long oddCount = charCount.values().stream()
            .filter(count -> count % 2 == 1)
            .count();

        return oddCount > 1 ? 0 : 1;
    }
}
