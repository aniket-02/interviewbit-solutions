import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int setIntersection(ArrayList<ArrayList<Integer>> A) {
        AtomicInteger result = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(-1);
        AtomicInteger secondMax = new AtomicInteger(-1);

        Collections.sort(A, (a, b) -> a.get(1) == b.get(1) ? b.get(0) - a.get(0) : a.get(1) - b.get(1));

        A.forEach(interval -> {
            int a = interval.get(0);
            int b = interval.get(1);

            if (max.get() >= a && secondMax.get() >= a) {
                return;
            }

            if (max.get() >= a) {
                secondMax.set(max.get());
                max.set(b);
                result.set(result.get() + 1);
            } else {
                secondMax.set(b - 1);
                max.set(b);
                result.set(result.get() + 2);
            }
        });

        return result.get();
    }
}
