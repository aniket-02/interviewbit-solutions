public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        
        for (int i = 0; i < n - 1; i += 2) {
            Collections.swap(A, i, i + 1);
        }
        
        return A;
    }
}
