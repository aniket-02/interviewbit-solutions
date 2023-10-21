public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        
        A.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        
        int count = 1;
        int index = 0;
        
        for (int i = 1; i < n; i++) {
            if (A.get(i).get(0) > A.get(index).get(1)) {
                count++;
                index = i;
            }
        }
        
        return count;
    }
}
