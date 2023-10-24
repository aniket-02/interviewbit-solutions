public class Solution {
    public int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int j = 0;

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);

            if (charMap.containsKey(currentChar)) {
                j = Math.max(charMap.get(currentChar) + 1, j);
            }

            charMap.put(currentChar, i);
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}