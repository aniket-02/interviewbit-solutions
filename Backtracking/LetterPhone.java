public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    String[] table = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> output = new ArrayList<>();
        letterCombinationsUtil(A.toCharArray(), A.length(), 0, output);
        return result;
    }
    
    private void letterCombinationsUtil(char[] A, int n, int index, ArrayList<String> output) {
        if (index == n) {
            StringBuilder sb = new StringBuilder();
            for (String o : output) {
                sb.append(o);
            }
            result.add(sb.toString());
            return;
        }
        
        String letters = table[A[index] - '0'];
        for (int i = 0; i < letters.length(); i++) {
            output.add(String.valueOf(letters.charAt(i)));
            letterCombinationsUtil(A, n, index + 1, output);
            output.remove(output.size() - 1);
        }
    }
}
