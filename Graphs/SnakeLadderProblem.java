public class Solution {
    private int[] getCoordinate(int value) {
        int row = (value - 1) / 10;
        int col = (value - 1) % 10;
        return new int[]{row, col};
    }

    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int[][] board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = -1;
            }
        }

        for (ArrayList<Integer> a : A) {
            int[] coordinates = getCoordinate(a.get(0));
            int k = coordinates[0];
            int j = coordinates[1];
            board[k][j] = a.get(1);
        }

        for (ArrayList<Integer> b : B) {
            int[] coordinates = getCoordinate(b.get(0));
            int k = coordinates[0];
            int j = coordinates[1];
            board[k][j] = b.get(1);
        }

        int[][] visited = new int[10][10];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[0][0] = 1;

        int dieRoles = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();
                for (int k = 1; k <= 6; k++) {
                    int[] coordinates = getCoordinate(currNode + k);
                    int row = coordinates[0];
                    int col = coordinates[1];
                    if (row >= 0 && row < 10 && col >= 0 && col < 10 && visited[row][col] == 0) {
                        visited[row][col] = 1;
                        if (currNode + k == 100 || board[row][col] == 100) {
                            return dieRoles + 1;
                        }
                        if (board[row][col] == -1) {
                            queue.add(currNode + k);
                        } else {
                            queue.add(board[row][col]);
                        }
                    }
                }
            }
            dieRoles++;
        }

        return -1;
    }
}
