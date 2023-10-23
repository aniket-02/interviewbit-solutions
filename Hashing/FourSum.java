public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        HashMap<Integer, ArrayList<Integer>> d = new HashMap<>();
        int n = A.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                if (!d.containsKey(sum)) {
                    d.put(sum, new ArrayList<Integer>());
                }
                d.get(sum).add(i);
                d.get(sum).add(j);
            }
        }
        
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentSum = A.get(i) + A.get(j);
                int target = B - currentSum;
                if (d.containsKey(target)) {
                    ArrayList<Integer> indexes = d.get(currentSum);
                    ArrayList<Integer> targetIndexes = d.get(target);
                    
                    for (int k = 0; k < indexes.size(); k += 2) {
                        for (int l = 0; l < targetIndexes.size(); l += 2) {
                            int index1 = indexes.get(k);
                            int index2 = indexes.get(k + 1);
                            int index3 = targetIndexes.get(l);
                            int index4 = targetIndexes.get(l + 1);
                            
                            if (index1 != index3 && index1 != index4 && index2 != index3 && index2 != index4) {
                                ArrayList<Integer> result = new ArrayList<>();
                                result.add(A.get(index1));
                                result.add(A.get(index2));
                                result.add(A.get(index3));
                                result.add(A.get(index4));
                                result.sort(null);
                                res.add(result);
                            }
                        }
                    }
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>(res);
        resultList.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        
        return resultList;
    }
}
