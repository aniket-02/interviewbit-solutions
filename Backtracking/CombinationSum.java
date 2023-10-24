public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public void combinationSumUtil(ArrayList<Integer> A, int n, int index, int B, ArrayList<Integer> combination) {
        if (B == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(combination);
            Collections.sort(temp);
            result.add(temp);
            return;
        }
        
        if (index == n) {
            return;
        }

        if (B >= A.get(index)) {
            combination.add(A.get(index));
            combinationSumUtil(A, n, index, B - A.get(index), combination);
            combination.remove(combination.size() - 1);
        }

        combinationSumUtil(A, n, index + 1, B, combination);
        
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        A = new ArrayList<>(new HashSet<Integer>(A));
        combinationSumUtil(A, A.size(), 0, B, combination);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
	        @Override
	        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
	            int an = a.size();
	            int bn = b.size();
	            for (int i = 0; i < Math.min(an, bn); i++) {
	                int cmp = Integer.compare(a.get(i), b.get(i));
	                if (cmp != 0)
	                    return cmp;
	            }
	            return Integer.compare(a.size(), b.size());
	        }
	    });
        return result;
    }
}
