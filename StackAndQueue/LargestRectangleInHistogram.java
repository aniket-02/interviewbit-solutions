public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();

        int left[] = new int[n];
        int right[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i))
                stack.pop();
            
            if (stack.isEmpty()) 
                left[i] = 0;
            else 
                left[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack = new Stack<>();

        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i))
                stack.pop();

            if (stack.isEmpty()) 
                right[i] = n - 1;
            else 
                right[i] = stack.peek() - 1;

            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, A.get(i) * (right[i] - left[i] + 1));
        }
        return maxArea;
    }
}
