public class Solution {
    public int numDecodings(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        
        if (A.charAt(0) == '0') {
            return 0;
        }
        
        int n = A.length();
        
        int[] result = new int[n + 1];
        result[0] = result[1] = 1;

        for (int i = 1; i < n; i ++) {
            int singleDigit = Integer.parseInt(A.substring(i, i + 1));
            int doubleDigit = Integer.parseInt(A.substring(i - 1, i + 1));
        
            if (singleDigit > 0 && singleDigit <= 9) {
                result[i + 1] = result[i] % 1000000007;
            }
            
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                result[i + 1] = (result[i + 1] + result[i - 1]) % 1000000007;
            }
            
            if (result[i + 1] == 0) {
                return 0;
            }
        }
        
        return result[n] % 1000000007;
    }
}
