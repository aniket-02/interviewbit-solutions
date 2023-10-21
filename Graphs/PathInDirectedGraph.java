public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[A + 1];
        int found = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (v == A) {
                return 1;
            }
            visited[v] = true;

            if (graph.containsKey(v)) {
                for (int _v : graph.get(v)) {
                    if (!visited[_v]) {
                        stack.push(_v);
                    }
                }
            }
        }

        return 0;
    }
}
