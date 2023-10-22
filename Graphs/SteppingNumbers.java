public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (A == 0) {
            result.add(0);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }
    
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int isWithinRange = withinRange(A, B, num);
            if (isWithinRange == 1) {
                result.add(num);
            } else if (isWithinRange == 0) {
                break;
            }
            
            if (num % 10 != 0) {
                queue.offer(num * 10 + (num % 10) - 1);
            }
            if (num % 10 != 9) {
                queue.offer(num * 10 + (num % 10) + 1);
            }
        }
        
        return result;
    }

    private int withinRange(int A, int B, int num) {
        if (num < A) {
            return -1;
        }
        return (A <= num && num <= B) ? 1 : 0;
    }
}
