public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        int l = 0;
        int r = 0;
        
        while (r < n) {
            while (!deque.isEmpty() && A.get(r) > A.get(deque.getLast())) {
                deque.removeLast();
            }
            deque.addLast(r);
            
            if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            
            if (r+1 >= B) {
                result.add(A.get(deque.getFirst()));
                l++;
            }
            r ++;
        }
        
        return result;
    }
}
