public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        int currentSum = 0;

        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            currentSum += num % 2;
            if (currentSum == B) {
                result++;
            }

            if (countMap.containsKey(currentSum - B)) {
                result += countMap.get(currentSum - B);
            }

            countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}