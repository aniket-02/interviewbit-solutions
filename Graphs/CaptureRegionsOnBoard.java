public class Solution {
    public void bfs(List<int[]> startingArray, ArrayList<ArrayList<Character>> a, int[][] visited) {
        for (int[] startPos : startingArray) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(startPos);
            visited[startPos[0]][startPos[1]] = 1;

            while (!queue.isEmpty()) {
                int[] currPos = queue.poll();
                int currI = currPos[0];
                int currJ = currPos[1];

                for (int[] dir : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
                    int nextI = currI + dir[0];
                    int nextJ = currJ + dir[1];

                    if (nextI >= 0 && nextI < a.size() && nextJ >= 0 && nextJ < a.get(0).size()
                            && visited[nextI][nextJ] == 0 && a.get(nextI).get(nextJ) == 'O') {
                        queue.offer(new int[]{nextI, nextJ});
                        visited[nextI][nextJ] = 1;
                    }
                }
            }
        }
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();
        int[][] visited = new int[n][m];
        List<int[]> starter = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.get(i).get(j) == 'O') {
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        starter.add(new int[]{i, j});
                    }
                }
            }
        }

        bfs(starter, a, visited);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1) {
                    a.get(i).set(j, 'O');
                } else {
                    a.get(i).set(j, 'X');
                }
            }
        }
    }
}
