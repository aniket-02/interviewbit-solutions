public class Solution {
    private Integer[] union;

    private int unionFind(int node) {
        if (union[node] == null) {
            return node;
        }
        union[node] = unionFind(union[node]);
        return union[node];
    }
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        union = new Integer[A + 1];

        for (ArrayList<Integer> bridge : B) {
            int x = bridge.get(0);
            int y = bridge.get(1);

            int parentX = unionFind(x);
            int parentY = unionFind(y);

            if (parentX == parentY) {
                return 1;
            } else {
                union[parentX] = parentY;
            }
        }

        return 0;
    }
}
