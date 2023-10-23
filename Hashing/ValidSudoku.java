public class Solution {
    public int isValidSudoku(final List<String> A) {
        int n = A.size();
        Set<Character>[] row = new HashSet[n];
        Set<Character>[] col = new HashSet[n];
        Set<Character>[] sec = new HashSet[n];

        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            sec[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char currentChar = A.get(i).charAt(j);
                if (currentChar != '.') {
                    int secIndex = (i / 3) * 3 + j / 3;
                    if (row[i].contains(currentChar) || col[j].contains(currentChar) || sec[secIndex].contains(currentChar)) {
                        return 0;
                    }
                    row[i].add(currentChar);
                    col[j].add(currentChar);
                    sec[secIndex].add(currentChar);
                }
            }
        }

        return 1;
    }
}