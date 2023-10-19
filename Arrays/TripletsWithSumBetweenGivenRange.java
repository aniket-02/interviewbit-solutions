public class Solution {
    public int solve(ArrayList<String> A) {
        int n = A.size();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(A.get(i));
        }

        double sum = 0.0;
        double x = arr[0];
        double y = arr[1];
        double z = arr[2];

        for (int i = 3; i < n; i++) {
            sum = x + y + z;
            if (1 < sum && sum < 2) {
                return 1;
            } else if (sum > 2) {
                if (x > y && x > z) {
                    x = arr[i];
                } else if (y > x && y > z) {
                    y = arr[i];
                } else {
                    z = arr[i];
                }
            } else {
                if (x < y && x < z) {
                    x = arr[i];
                } else if (y < x && y < z) {
                    y = arr[i];
                } else {
                    z = arr[i];
                }
            }
        }

        sum = x + y + z;
        return (1 < sum && sum < 2) ? 1 : 0;
    }
}
