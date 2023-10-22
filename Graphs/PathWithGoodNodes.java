public class Solution {
    public void dfs(ArrayList<Integer> A, Map<Integer, ArrayList<Integer>> map, int goodNodes, int currentNode, int C, boolean[] visited, int[] result) {
        visited[currentNode] = true;
        if (A.get(currentNode) == 1) {
            goodNodes ++;            
        }
        if (map.get(currentNode).size() == 1) {
            if (goodNodes <= C) {
                result[0] ++;
            }
            return;
        }
        for (int node : map.get(currentNode)) {
            if (!visited[node]) {
                dfs(A, map, goodNodes, node, C, visited, result);
            }
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        A.add(0, 0);

        for (ArrayList<Integer> edge : B) {
            if (!map.containsKey(edge.get(0))) {
                map.put(edge.get(0), new ArrayList<Integer>());
            }
            if (!map.containsKey(edge.get(1))) {
                map.put(edge.get(1), new ArrayList<Integer>());
            }
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] result = {0};
        boolean[] visited = new boolean[A.size() + 1];
        dfs(A, map, 0, 1, C, visited, result);
        
        return result[0];    
    }
}
