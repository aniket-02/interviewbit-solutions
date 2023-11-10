public class Solution {
    private void DFSUtil(Map<Integer, ArrayList<Integer>> graph, int vertex, boolean[] visited)
    {
        visited[vertex] = true;

        for (int v : graph.get(vertex)) {
            if (!visited[v]) {
                DFSUtil(graph, v, visited);
            }
        }
    }
    
    public int motherVertex(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] visited = new boolean[A+1];
 
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= A; i ++) {
            graph.put(i, new ArrayList<Integer>()); 
        }
        
        for (ArrayList<Integer> edge : B) {
            graph.get(edge.get(0)).add(edge.get(1));
        }
        
        int motherVertex = -1;
 
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                DFSUtil(graph, i, visited);
                motherVertex = i;
            }
        }
        
        visited = new boolean[A+1];
        visited[0] = true;
        DFSUtil(graph, motherVertex, visited);
        for (boolean value : visited) {
            if (!value) {
                return 0;
            }
        }
        return 1;
    }
}
