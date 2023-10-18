import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        Collections.reverse(A);
        AtomicInteger carry = new AtomicInteger(1);
        
        List<Integer> result = A.stream()
            .map(x -> {
                int newValue = x + carry.get();
                carry.set(0);
                if (newValue >= 10) {
                    newValue = newValue % 10;
                    carry.set(1);
                }
                return newValue;
            })
            .collect(Collectors.toList());

        if (carry.get() > 0) {
            result.add(carry.get());
        }
        
        Collections.reverse(result);
        
        int k = 0;
        for (Integer value : result) {
            if (value == 0) {
                k ++;
            } else {
                break;
            }
        }

        return new ArrayList<Integer>(result.subList(k, result.size()));
    }
}