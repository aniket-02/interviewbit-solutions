public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            left[i] = 0;

            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (A.get(top) > A.get(i)) {
                    left[i] = top;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 0;

            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (A.get(top) > A.get(i)) {
                    right[i] = top;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }

        long maxVal = 0;
        for (int i = 0; i < n; i++) {
            long prod = (long)((long) left[i] * (long)right[i]);
            maxVal = Math.max(maxVal, prod) % 1000000007;
        }

        return (int) (maxVal % 1000000007);
    }
}
