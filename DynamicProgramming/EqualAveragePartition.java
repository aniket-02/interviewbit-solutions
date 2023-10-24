public class Solution {
    public boolean check(int ind, int sum, int element, ArrayList<Integer> A,
            boolean[][][] dp, ArrayList<Integer> res) {
        if (element == 0)
            return sum == 0;
        if (ind >= A.size())
            return false;

        if (!dp[ind][sum][element])
            return false;

        if (A.get(ind) <= sum) {
            res.add(A.get(ind));
            if (check(ind + 1, sum - A.get(ind), element - 1, A, dp, res))
                return dp[ind][sum][element] = true;
            res.remove(res.size() - 1);
        }

        if (check(ind + 1, sum, element, A, dp, res))
            return dp[ind][sum][element] = true;

        return dp[ind][sum][element] = false;
    }
    
    public void getSecondPartition(ArrayList<Integer> A, ArrayList<Integer> firstPartition) {
        for (int i = 0; i < firstPartition.size(); i ++) {
            Iterator itr = A.iterator(); 
            while (itr.hasNext()) { 
                int value = (Integer)itr.next(); 
                if (value == firstPartition.get(i)) {
                    itr.remove();
                    break;
                } 
            } 
        }
    }

    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        int sum = A.stream().mapToInt(Integer::intValue).sum();
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        boolean[][][] dp = new boolean[n][sum + 1][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = true;
                }
            }
        }
        
        for (int i = 1; i < n; i ++) {
            if ((sum * i) % n != 0) {
				continue;                
            }

            int subset_sum = (sum * i) / n;
            
            ArrayList<Integer> firstPartition = new ArrayList<Integer>();
            
            if (check(0, subset_sum, i, A, dp, firstPartition)) {
                getSecondPartition(A, firstPartition);

                result.add(firstPartition);
                result.add(A);
                break;
            }
        }
        
        return result;
    }
}
