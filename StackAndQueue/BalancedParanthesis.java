public class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
