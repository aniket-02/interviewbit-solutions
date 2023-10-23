public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int minIndex = n + 1;
        for (int i = 0; i < n; i ++) {
            if (map.containsKey(A.get(i)) && map.get(A.get(i)) < minIndex) {
                minIndex = map.get(A.get(i));
            }
            map.put(A.get(i), i);
        }
        if (minIndex == n + 1) {
            return -1;
        }
        return A.get(minIndex);
    }
}