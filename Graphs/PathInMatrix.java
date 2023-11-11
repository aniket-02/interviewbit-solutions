public class Solution {
    private boolean inLimits(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    private boolean bfs(ArrayList<ArrayList<Integer>> A, int srcX, int srcY) {
        boolean[][] visited = new boolean[A.size()][A.size()];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { srcX, srcY });
        visited[srcX][srcY] = true;

        int[][] moves = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int[] move : moves) {
                int newX = position[0] + move[0];
                int newY = position[1] + move[1];
                
                if (inLimits(newX, newY, A.size(), A.get(0).size()) && A.get(newX).get(newY) != 0 && !visited[newX][newY]) {
                    if (A.get(newX).get(newY) == 2)
                        return true;
                    queue.offer(new int[] { newX, newY });
                    visited[newX][newY] = true;
                }
            }
        }
        
        return false;
    }
    
    public int checkPath(ArrayList<ArrayList<Integer>> A) {
        int srcX = -1;
        int srcY = -1;
        
        int n = A.size();
        int m = A.get(0).size();
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (A.get(i).get(j) == 1) {
                    srcX = i;
                    srcY = j;
                    break;
                }
            }
        }
        
        if (bfs(A, srcX, srcY))
            return 1;
        return 0;
    }
}
