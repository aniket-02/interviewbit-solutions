public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parents = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parents[i] = -1;
        }

        for (ArrayList<Integer> edge : B) {
            int a = edge.get(0);
            int b = edge.get(1);
            int temp = parents[a];

            while (temp != -1) {
                if (temp == b) {
                    return 1;
                }
                temp = parents[temp];
            }

            parents[b] = a;
        }
        return 0;
    }
}
