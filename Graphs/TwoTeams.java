import java.util.*;

public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 1; i <= A; i ++) {
             map.put(i, new ArrayList<Integer>());
        }
        
        for (ArrayList<Integer> edge : B) {
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] color = new int[A + 1];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= A; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q.add(i);
            }

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int neighbor : map.get(node)) {
                    if (color[node] == color[neighbor]) {
                        return 0;
                    }

                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        q.add(neighbor);
                    }
                }
            }
        }

        return 1;
    }
}
