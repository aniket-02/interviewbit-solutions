import java.util.*;

public class Solution {

    public int solve(int numberOfNodes, ArrayList<ArrayList<Integer>> edgesList, int source, int destination, ArrayList<ArrayList<Integer>> extraEdges) {

        int[] distanceFromSource = new int[numberOfNodes + 1];
        int[] distanceFromDestination = new int[numberOfNodes + 1];
        Arrays.fill(distanceFromSource, Integer.MAX_VALUE);
        Arrays.fill(distanceFromDestination, Integer.MAX_VALUE);
        distanceFromSource[source] = 0;
        distanceFromDestination[destination] = 0;

        Map<Integer, ArrayList<int[]>> adjacencyList = buildAdjacencyList(edgesList);

        dijkstra(source, distanceFromSource, adjacencyList);
        dijkstra(destination, distanceFromDestination, adjacencyList);

        int resultDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= numberOfNodes; i++) {
            resultDistance = Math.min(distanceFromSource[i] + distanceFromDestination[i], resultDistance);
        }

        for (ArrayList<Integer> extraEdge : extraEdges) {
            int u = extraEdge.get(0);
            int v = extraEdge.get(1);
            int w = extraEdge.get(2);

            if (u > numberOfNodes || v > numberOfNodes) {
                return -1;
            }

            if (distanceFromSource[u] + w < distanceFromSource[v]) {
                resultDistance = Math.min(distanceFromSource[u] + w + distanceFromDestination[v], resultDistance);
            }

            if (distanceFromSource[v] + w < distanceFromSource[u]) {
                resultDistance = Math.min(distanceFromSource[v] + w + distanceFromDestination[u], resultDistance);
            }
        }

        return resultDistance < 0 ? -1 : resultDistance;
    }

    private Map<Integer, ArrayList<int[]>> buildAdjacencyList(ArrayList<ArrayList<Integer>> edgesList) {
        Map<Integer, ArrayList<int[]>> adjacencyList = new HashMap<>();

        for (ArrayList<Integer> edge : edgesList) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            adjacencyList.putIfAbsent(u, new ArrayList<>());
            adjacencyList.get(u).add(new int[]{v, weight});

            adjacencyList.putIfAbsent(v, new ArrayList<>());
            adjacencyList.get(v).add(new int[]{u, weight});
        }

        return adjacencyList;
    }

    private void dijkstra(int start, int[] distances, Map<Integer, ArrayList<int[]>> adjacencyList) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();

        while (visited.size() != distances.length - 1) {
            if (minHeap.isEmpty()) {
                break;
            }

            int[] current = minHeap.poll();
            int node = current[0];
            int distance = current[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            ArrayList<int[]> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>());
            for (int[] neighbor : neighbors) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = distance + weight;

                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    minHeap.add(new int[]{nextNode, newDistance});
                }
            }
        }
    }
}
