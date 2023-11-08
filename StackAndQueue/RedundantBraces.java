public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        char[] operators = {'+', '*', '/', '-'};

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);
            if (currentChar == '(') {
                stack.push(currentChar);
            }
            if (new String(operators).indexOf(currentChar) != -1 && !stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
