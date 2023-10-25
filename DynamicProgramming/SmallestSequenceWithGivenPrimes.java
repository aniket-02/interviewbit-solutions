public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        Set<Integer> d = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (!d.contains(A)) {
            heap.offer(A);
            d.add(A);
        }
        if (!d.contains(B)) {
            heap.offer(B);
            d.add(B);
        }
        if (!d.contains(C)) {
            heap.offer(C);
            d.add(C);
        }

        while (D > 0) {
            D--;
            int element = heap.poll();
            result.add(element);

            if (!d.contains(element * A)) {
                heap.offer(element * A);
                d.add(element * A);
            }
            if (!d.contains(element * B)) {
                heap.offer(element * B);
                d.add(element * B);
            }
            if (!d.contains(element * C)) {
                heap.offer(element * C);
                d.add(element * C);
            }
        }

        return result;
    }
}
