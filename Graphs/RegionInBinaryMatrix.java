public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int result = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        result = Math.max(result, bfs(A, m, n, queue));

        return result;
    }

    private int bfs(ArrayList<ArrayList<Integer>> A, int m, int n, Queue<int[]> queue) {
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 0) {
                    continue;
                }

                int count = 0;
                queue.add(new int[]{i, j});
                A.get(i).set(j, 0);

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int ni = current[0];
                    int nj = current[1];
                    count++;

                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int ni2 = ni + dx;
                            int nj2 = nj + dy;

                            if (ni2 == ni && nj2 == nj) {
                                continue;
                            }

                            if (ni2 >= 0 && ni2 < m && nj2 >= 0 && nj2 < n && A.get(ni2).get(nj2) == 1) {
                                A.get(ni2).set(nj2, 0);
                                queue.add(new int[]{ni2, nj2});
                            }
                        }
                    }
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
