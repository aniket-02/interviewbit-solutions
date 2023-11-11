class Position {
    int x, y, level;

    public Position(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

public class Solution {
    private boolean check(int i, int j, int A, int B) {
        return i < A && i >= 0 && j < B && j >= 0;
    }

    private boolean isEmpty(Queue<Position> q) {
        return q.isEmpty();
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        C -= 1;
        D -= 1;
        E -= 1;
        F -= 1;

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        if (C == E && D == F) {
            return 0;
        }

        boolean[][] visited = new boolean[A][B];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(C, D, 0));

        visited[C][D] = true;

        while (!isEmpty(queue)) {
            Position position = queue.poll();
            int x = position.x, y = position.y, level = position.level;

            for (int k = 0; k < 8; k++) {
                int _x = x + dx[k];
                int _y = y + dy[k];

                if (check(_x, _y, A, B) && !visited[_x][_y]) {
                    if (_x == E && _y == F) {
                        return level + 1;
                    }
                    visited[_x][_y] = true;
                    queue.add(new Position(_x, _y, level + 1));
                }
            }
        }

        return -1;
    }
}
