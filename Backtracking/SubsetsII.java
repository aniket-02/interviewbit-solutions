public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public void subsetsWithDupUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int index, int n) {
        if (index == n) {
            ArrayList<Integer> temp = new ArrayList<Integer>(subset);
            Collections.sort(temp);
            result.add(temp);
            return;    
        }
        subset.add(A.get(index));
        subsetsWithDupUtil(A, subset, index + 1, n);

        int j = index + 1;
        
        while (j < n && A.get(index) == A.get(j)) {
            j ++;
        }
        subset.remove(subset.size() - 1);
        subsetsWithDupUtil(A, subset, j, n);

    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsetsWithDupUtil(A, subset, 0, A.size());
        
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
