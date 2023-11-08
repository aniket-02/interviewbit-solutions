public class Solution {
    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();

        for (char c : A.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char element = stack.pop();

                if ((c == ']' && element != '[') || (c == '}' && element != '{') || (c == ')' && element != '(')) {
                    return 0;
                }
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
