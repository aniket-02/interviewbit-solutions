import java.util.List;

public class Solution {

    public int cntBits(List<Integer> A) {
        long answer = 0;
        int n = A.size();
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) != 0) {
                    count++;
                }
            }
            
            answer = (answer + (long) count * (n - count) * 2) % 1000000007;
        }

        return (int) answer;
    }
}
