public class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
    	visited[start] = true;

    	for (int node: graph.get(start)) {
    		if (!visited[node]) {
    			dfs(graph, node, visited);
    		}
    	}
    }
    
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
    	boolean[] visited = new boolean[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= n; i++){
			graph.add(i, new ArrayList<Integer>());
		}

    	for (int i = 1; i < n; i ++) {
			graph.get(i+1).add(A.get(i));
			graph.get(A.get(i)).add(i+1);
    	}
    	
    	Arrays.fill(visited, false);
    	int result = 0;
    	
    	for (int i = 1; i <= n; i ++) {
    	    if (!visited[i]) {
    	        result ++;
    	        dfs(graph, i, visited);
    	    } 
    	}
    	return result - 1;
    }
    

}