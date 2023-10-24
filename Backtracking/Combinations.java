public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public void combineUtil(int A, int B, int value, ArrayList<Integer> combination) {
        if (B == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        if (value > A) {
            return;
        }
        
        combination.add(value);
        combineUtil(A, B - 1, value + 1, combination);
        combination.remove(combination.size() - 1);
        combineUtil(A, B, value + 1, combination);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        combineUtil(A, B, 1, combination);

        return result;
    }
}
