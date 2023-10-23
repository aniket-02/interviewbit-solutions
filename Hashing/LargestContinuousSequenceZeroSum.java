public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int n = A.size();

        HashMap<Integer, Integer> d = new HashMap<>();
        d.put(0, -1);
        int sumUptilHere = 0;
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            sumUptilHere += A.get(i);

            if (d.containsKey(sumUptilHere)) {
                int startIndex = d.get(sumUptilHere);
                if (i - startIndex > end - start) {
                    start = startIndex;
                    end = i;
                }
            } else {
                d.put(sumUptilHere, i);
            }
        }
        
        return new ArrayList<>(A.subList(start + 1, end + 1));

    }
}