public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // Find rows and columns with zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set rows to zeros
        for (int i = 0; i < n; i++) {
            if (row[i]) {
                for (int j = 0; j < m; j++) {
                    A.get(i).set(j, 0);
                }
            }
        }

        // Set columns to zeros
        for (int j = 0; j < m; j++) {
            if (col[j]) {
                for (int i = 0; i < n; i++) {
                    A.get(i).set(j, 0);
                }
            }
        }
	}
}
