public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        boolean[][] visited = new boolean[A + 1][B + 1];

        for (int x = 0; x <= A; x++) {
            for (int y = 0; y <= B; y++) {
                for (int i = 0; i < C; i++) {
                    int x0 = E.get(i);
                    int y0 = F.get(i);
                    if (Math.pow(x - x0, 2) + Math.pow(y - y0, 2) <= Math.pow(D, 2)) {
                        visited[x][y] = true;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == A && y == B) {
                return "YES";
            }

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;

                    if (nx == x && ny == y) {
                        continue;
                    }

                    if (nx >= 0 && nx <= A && ny >= 0 && ny <= B && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return "NO";
    }
}
