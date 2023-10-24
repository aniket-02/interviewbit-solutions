public class Solution {
    ArrayList<String> result = new ArrayList<>();

    public void specialStringsUtil(ArrayList<String> A, String str, int index, int n) {
        if (index == n) {
            result.add(str);
            return;
        }
        
        for (int i = 0; i < A.get(index).length(); i ++) {
            str += A.get(index).charAt(i);
            specialStringsUtil(A, str, index + 1, n);
            str = str.substring(0, str.length() - 1);
        }
    }

    public ArrayList<String> specialStrings(ArrayList<String> A) {
        specialStringsUtil(A, "", 0, A.size());
        return result;
    }
}
