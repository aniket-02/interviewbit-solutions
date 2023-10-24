public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        Map<Integer, Integer> d = new HashMap<>();
        int result = 0;
        
        d.put(0, 1);
        int val = 0;
        
        for (int i = 0; i < n; i++) {
            val = val ^ A.get(i);
            if (d.containsKey(val ^ B)) {
                result += d.get(val ^ B);
            }
            d.put(val, d.getOrDefault(val, 0) + 1);
        }
        
        return result;
    }
}