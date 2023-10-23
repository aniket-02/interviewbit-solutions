public class Solution {
public ArrayList<Integer> equal(ArrayList<Integer> A) {
        int n = A.size();
        Map<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                if (sumMap.containsKey(sum)) {
                    ArrayList<Integer> list = sumMap.get(sum);
                    if (list.get(0) != i && list.get(1) != j && list.get(0) != j && list.get(1) != i) {
                        ArrayList<Integer> currentResult = new ArrayList<>();
                        currentResult.add(list.get(0));
                        currentResult.add(list.get(1));
                        currentResult.add(i);
                        currentResult.add(j);

                        if (result.isEmpty() || isSmaller(currentResult, result)) {
                            result = new ArrayList<>(currentResult);
                        }
                    }
                } else {
                    ArrayList<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    sumMap.put(sum, indexes);
                }
            }
        }

        return result;
    }

    private boolean isSmaller(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < b.get(i)) return true;
            if (a.get(i) > b.get(i)) return false;
        }
        return false;
    }
}
