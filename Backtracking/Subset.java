public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public void subsetsUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int index, int n) {
        if (index == n) {
            ArrayList<Integer> temp = new ArrayList<Integer>(subset);
            Collections.sort(temp);
            result.add(temp);
            return;    
        }

        subsetsUtil(A, subset, index + 1, n);
        subset.add(A.get(index));
        subsetsUtil(A, subset, index + 1, n);
        subset.remove(subset.size() - 1);

    }
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsetsUtil(A, subset, 0, A.size());
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
