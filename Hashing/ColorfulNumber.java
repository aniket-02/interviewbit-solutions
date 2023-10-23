public class Solution {
    public int colorful(int A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        while (A > 0) {
            int product = 1;
            int B = A;

            while (B > 0) {
                product *= (B % 10);
                B /= 10;
                if (map.containsKey(product)) {
                    return 0;
                }
                map.put(product, 1);
            }

            A /= 10;
        }

        return 1;
    }
}