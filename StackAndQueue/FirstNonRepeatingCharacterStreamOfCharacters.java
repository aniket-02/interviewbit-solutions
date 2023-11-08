public class Solution {
    public String solve(String A) {
        int n = A.length();
        
        StringBuilder result = new StringBuilder();
        
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i ++) {
            char currentChar = A.charAt(i);
            queue.add(currentChar);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove();
            }
            
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }
        
        return result.toString();
    }
}
