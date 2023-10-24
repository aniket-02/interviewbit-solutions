public class Solution {
    public String minWindow(String A, String B) {
        int n = B.length();
        int m = A.length();

        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char ch = B.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    
        int i = 0, j = 0;
        int count = map.size();
        String result = "";
        int minLen = Integer.MAX_VALUE;
        
        while (j < m) {
            char currentChar = A.charAt(j);
            
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                
                if (map.get(currentChar) == 0) {
                    count --;
                }
                
                while (count == 0) {
                    if (result.isEmpty() || j - i + 1 < minLen) {
                        result = A.substring(i, j + 1);
                        minLen = j - i + 1;
                    }
                
                    char startChar = A.charAt(i);
                    if (map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1);
                        if (map.get(startChar) > 0) {
                            count ++;
                        }
                    }
                    i ++;
                }
            }
            j ++;
        }
    
        return result;
    }
}
