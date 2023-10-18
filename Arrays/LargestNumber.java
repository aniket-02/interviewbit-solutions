import java.util.stream.Collectors;
public class Solution {
    public String largestNumber(final List<Integer> A) {
        if (A.isEmpty()) {
            return "0";
        }

        Comparator<String> compare = (n1, n2) -> {
            String str1 = n1 + n2;
            String str2 = n2 + n1;
            return str2.compareTo(str1);
        };

        List<String> strList = A.stream()
            .map(String::valueOf)
            .sorted(compare)
            .collect(Collectors.toList());

        if (strList.get(0).equals("0")) {
            return "0";
        }

        return strList.stream().collect(Collectors.joining());
    }
}
