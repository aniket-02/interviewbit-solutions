public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            int complement = B - num;
            
            if (map.containsKey(complement)) {
                result.add(map.get(complement) + 1);
                result.add(i + 1);
                return result;
            }
            
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }
        
        return result;
    }
}
