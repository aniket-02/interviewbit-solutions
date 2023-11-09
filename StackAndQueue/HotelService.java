class Coordinate {
    int X;
    int Y;

    public Coordinate(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
}

public class Solution {
    public ArrayList<Integer> nearestHotel(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = A.get(0).size();
        Queue<Coordinate> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    q.add(new Coordinate(i, j));
                    A.get(i).set(j, 0);
                } else {
                    A.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }
        
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            Coordinate top = q.poll();
            int x = top.X;
            int y = top.Y;
            int time = A.get(x).get(y);
            
            for (int i = 0; i < 4; i++) {
                int newx = x + row[i];
                int newy = y + col[i];
                
                if (newx >= 0 && newx < n && newy >= 0 && newy < m && A.get(newx).get(newy) == Integer.MAX_VALUE) {
                    A.get(newx).set(newy, time + 1);
                    q.add(new Coordinate(newx, newy));
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (List<Integer> point : B) {
            int i = point.get(0);
            int j = point.get(1);
            res.add(A.get(i - 1).get(j - 1));
        }
        
        return res;
    }
}
