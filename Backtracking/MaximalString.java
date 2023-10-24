public class Solution {
    ArrayList<String> result = new ArrayList<String>();

    public String swap(String A, int i, int j) {
        char[] charArray = A.toCharArray();

        if (i >= 0 && i < A.length() && j >= 0 && j < A.length()) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        return new String(charArray);
    }

    public void solveUtil(String A, int B, int n) {
        if (B == 0) {
            return;
        }
        
        for (int i = 0; i < n; i ++) {
            for (int j = i+1; j < n; j ++) {
                A = swap(A, i, j);
                
                solveUtil(A, B - 1, n);
                
                if (A.compareTo(result.get(0)) > 0) {
                    result.set(0, A);
                }
                
                A = swap(A, i, j);
            }
        }        
    }

    public String solve(String A, int B) {
        result.add(A);
        solveUtil(A, B, A.length());
        
        return result.get(0);
    }
}
