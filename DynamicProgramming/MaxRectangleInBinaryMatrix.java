public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        
        int maxArea = 0;
        int[] heights = new int[m];

        for (int j = 0; j < m; j++) {
            heights[j] = A.get(0).get(j);
        }

        maxArea = maxRectHist(heights);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += A.get(i).get(j);
                }
            }

            maxArea = Math.max(maxRectHist(heights), maxArea);
        }

        return maxArea;
    }
    
        private int maxRectHist(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }

        return maxArea;
    }
}
