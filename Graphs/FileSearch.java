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
    
    public int breakRecords(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= A; i ++) {
            graph.put(i, new ArrayList<Integer>()); 
        }
        
        for (ArrayList<Integer> edge : B) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        boolean[] visited = new boolean[A+1];
        
        int count = 0;
        
        for (int i = 1; i <= A; i ++) {
            if (!visited[i]) {
                DFSUtil(graph, i, visited);
                count ++;
            }
        }
        
        return count;
    }
}
