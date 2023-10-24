public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Set<Integer> setA = new HashSet<>(A);
        Set<Integer> setB = new HashSet<>(B);
        Set<Integer> setC = new HashSet<>(C);
        
        Set<Integer> setAnew = new HashSet<>(A);
        Set<Integer> setBnew = new HashSet<>(B);
        Set<Integer> setCnew = new HashSet<>(C);
        
        setAnew.retainAll(setB);
        setBnew.retainAll(setC);
        setCnew.retainAll(setA);
        
        setAnew.addAll(setBnew);
        setAnew.addAll(setCnew);
        
        TreeSet<Integer> sortedSet = new TreeSet<>(setAnew);
        return new ArrayList<>(sortedSet);
    }
}
