public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size() - 1;

        List<Integer> result = new ArrayList<>();

        while (i <= j) {
            if (Math.abs(A.get(i)) > Math.abs(A.get(j))) {
                result.add(A.get(i) * A.get(i));
                i++;
            } else {
                result.add(A.get(j) * A.get(j));
                j--;
            }
        }
        Collections.reverse(result);
        return new ArrayList(result);
    }
}
