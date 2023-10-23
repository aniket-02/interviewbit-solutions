public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        
        for (int i = 0; i < n; i++) {
            int current = A.get(i);
            
            if (map.containsKey(current - B) || map.containsKey(current + B)) {
                return 1;
            }
            
            map.put(current, i);
        }
        
        return 0;
    }
}
