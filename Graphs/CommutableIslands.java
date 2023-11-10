public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parent = new int[A + 1];
        Arrays.fill(parent, -1);

        int cost = 0;
        
        int[][] bridges = new int[B.size()][3];
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> bridge = B.get(i);
            for (int j = 0; j < 3; j++) {
                bridges[i][j] = bridge.get(j);
            }
        }

        Arrays.sort(bridges, Comparator.comparingInt(a -> a[2]));

        for (int[] bridge : bridges) {
            int x = bridge[0];
            int y = bridge[1];
            int c = bridge[2];

            int px = find(parent, x);
            int py = find(parent, y);

            if (px != py) {
                cost += c;
                parent[px] = py;
            }
        }

        return cost;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
