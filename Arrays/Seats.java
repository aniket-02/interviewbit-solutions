public class Solution {
    public int seats(String A) {
        int n = A.length();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                pos.add(i);
            }
        }

        int p = pos.size();

        if (p == 0 || p == n) {
            return 0;
        }

        int mid = p / 2;
        int res = 0;

        for (int i = 0; i < p; i++) {
            int s = pos.get(i);
            int e = pos.get(mid) - mid + i;
            res = (res + Math.abs(e - s)) % 10000003;
        }

        return res % 10000003;
    }
}
