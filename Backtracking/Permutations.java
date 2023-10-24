public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public void permuteUtil(ArrayList<Integer> A, int n, ArrayList<Integer> combination) {
        if (combination.size() == n) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for (int i = 0; i < n; i ++) {
            if (combination.contains(A.get(i))) {
                continue;
            }
            combination.add(A.get(i));
            permuteUtil(A, n, combination);
            combination.remove(combination.size() - 1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        permuteUtil(A, A.size(), combination);
        return result;
    }
}
