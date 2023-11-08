public class Solution {
    public String reverseString(String A) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < A.length(); i ++) {
            stack.push(A.charAt(i));
        }
        
        String result = "";
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
