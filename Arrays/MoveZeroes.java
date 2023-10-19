public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int i = 0;
        int j = 0;
        int n = A.size();

        while (j < n) {
            if (A.get(j) != 0) {
                Collections.swap(A, i, j);
                i++;
            }
            j++;
        }

        return A;
    }
}
