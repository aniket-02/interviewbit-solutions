public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int ele : A) {
            hashTable.put(ele, 1);
        }
        
        int count = 0;
        for (int ele : A) {
            if (hashTable.containsKey(ele ^ B)) {
                count++;
            }
        }
        
        return count / 2;
    }
}
