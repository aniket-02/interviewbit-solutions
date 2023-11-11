public class Solution {
    private boolean isCyclic(Map<Integer, ArrayList<Integer>> graph, int vertex, 
        boolean[] visited, boolean[] recStack) {
        
        if (recStack[vertex])
            return true;
 
        if (visited[vertex])
            return false;
 
        visited[vertex] = true;
        recStack[vertex] = true;
 
        for (int v : graph.get(vertex))
            if (isCyclic(graph, v, visited, recStack))
                return true;
        recStack[vertex] = false;
        return false;
    }
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        boolean[] visited = new boolean[A+1];
        boolean[] recStack = new boolean[A+1];
        
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= A; i ++) {
            graph.put(i, new ArrayList<Integer>()); 
        }
        
        int n = B.size();
        
        for (int i = 0; i < n; i ++) {
            graph.get(B.get(i)).add(C.get(i));
        }
        
        visited[0] = true;

        for (int i = 1; i <= A; i++)
            if (isCyclic(graph, i, visited, recStack))
                return 0;
        
        return 1;
    }
}
