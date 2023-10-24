public class Solution {    
    public ArrayList<Integer> grayCode(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < (1 << A); i ++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
