public class Solution {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> convertedA = new ArrayList<>();
        for (int num : A) {
            convertedA.add((num == 0) ? -1 : 1);
        }

        int sumHere = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < convertedA.size(); i++) {
            sumHere += convertedA.get(i);

            if (sumHere == 1) {
                maxLen = i + 1;
            }

            if (!map.containsKey(sumHere)) {
                map.put(sumHere, i);
            }

            if (map.containsKey(sumHere - 1)) {
                maxLen = Math.max(maxLen, i - map.get(sumHere - 1));
            }
        }

        return maxLen;
    }
}
