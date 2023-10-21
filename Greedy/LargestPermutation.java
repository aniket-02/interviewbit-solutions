public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        
        for (int i = 0; i < n; i++) {
            map.put(A.get(i), i);
        }

        for (int i = 0; i < n; i++) {
            if (B == 0) {
                break;
            }
            if (A.get(i) == n - i) {
                continue;
            }

            int index = map.get(n - i);
            map.put(A.get(i), map.get(n - i));
            map.put(n - i, i);

            int temp = A.get(i);
            A.set(i, A.get(index));
            A.set(index, temp);

            B -= 1;
        }
        
        return A;
    }
}
