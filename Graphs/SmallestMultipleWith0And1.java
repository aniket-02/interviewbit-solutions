public class Solution {
    public String multiple(int A) {
        if (A == 1)
            return "1";
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        int[] parent = new int[A];
        int[] state = new int[A];
        int[] steps = {0,1};
        
        Arrays.fill(parent,-1);
        Arrays.fill(state,-1);
        
        queue.offer(1);
        parent[1] = Integer.MIN_VALUE;
        state[1] = 1;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == 0)
                break;
            for (int step : steps) {
                int next = current * 10 + step;
                next %= A;
                
                if (parent[next] == -1) {
                    parent[next] = current;
                    state[next] = step;
                    queue.offer(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index != Integer.MIN_VALUE) {
            sb.append(""+state[index]);
            index = parent[index];
        }
        return sb.reverse().toString();
    }
}

