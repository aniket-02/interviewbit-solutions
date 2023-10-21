public class Solution {
    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        
        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i - 1)) {
                result.add(result.get(i - 1) + 1);
            } else {
                result.add(1);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1) && result.get(i) <= result.get(i + 1)) {
                result.set(i, result.get(i + 1) + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }
}
