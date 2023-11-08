public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        
        for (int i = 0; i < n; i ++) {
            String currentStr = A.get(i);
            try {
                int num = Integer.parseInt(currentStr);
                stack.push(num);
            } catch (Exception e) {
                int a = stack.pop();
                int b = stack.pop();
                
                if (currentStr.equals("+"))
                    stack.push(a+b);
                else if (currentStr.equals("-"))
                    stack.push(b-a);
                else if (currentStr.equals("*"))
                    stack.push(a*b);
                else if (currentStr.equals("/"))
                    stack.push((int)(b / a));
            }
        }
        
        return stack.peek();
    }
}
