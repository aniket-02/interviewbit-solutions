public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> anagramGroups = new HashMap<>();

        for (int index = 0; index < A.size(); index++) {
            String word = A.get(index);
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (!anagramGroups.containsKey(sortedWord)) {
                anagramGroups.put(sortedWord, new ArrayList<>());
            }

            anagramGroups.get(sortedWord).add(index + 1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(anagramGroups.values());
        return result;
    }
}
