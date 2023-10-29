public class Solution {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(B);
        List<List<String>> sentences = wordBreakUtil(A, wordSet);

        for (List<String> sentence : sentences) {
            result.add(String.join(" ", sentence));
        }

        Collections.sort(result);
        return result;
    }

    private List<List<String>> wordBreakUtil(String s, Set<String> wordSet) {        
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add(new ArrayList<String>());
        } else {
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (wordSet.contains(prefix)) {
                    List<List<String>> sentences = wordBreakUtil(s.substring(i), wordSet);
                    for (List<String> sentence : sentences) {
                        List<String> temp = new ArrayList<>(sentence);
                        temp.add(0, prefix);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
}
