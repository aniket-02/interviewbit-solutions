public class Solution {
    private int Max(int a, int b, int c, int d) {
        return Math.max(Math.max(Math.max(a, b), c), d);
    }
    
    public int maxp3(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
    
        return Max(A.get(0) * A.get(1) * A.get(2), A.get(0) * A.get(1) * A.get(n - 1), A.get(0) * A.get(n - 2) * A.get(n - 1), A.get(n - 3) * A.get(n - 2) * A.get(n - 1));
    }
}
