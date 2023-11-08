public class Solution {
    public String simplifyPath(String A) {
        String[] splitA = A.split("/");
        int n = splitA.length;
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (!splitA[i].equals("")) {
                if (splitA[i].equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!splitA[i].equals(".")) {
                    stack.push(splitA[i]);
                }
            }
        }
        
        StringBuilder result = new StringBuilder("/");
        result.append(String.join("/", stack));
        return result.toString();
    }
}
