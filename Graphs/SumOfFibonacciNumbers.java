public class Solution {
    public int fibonacciSum(ArrayList<Integer> fib, int A) {
        int res = 0;
        int index = fib.size() - 1;

        while (A > 0) {
            if (fib.get(index) <= A) {
                res++;
                A -= fib.get(index);
            }
            index--;
        }
        return res;
    }

    public int fibsum(int A) {
        int a = 1, b = 1;
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(a);
        fib.add(b);

        while (a + b <= A) {
            fib.add(a + b);
            int temp = a;
            a = b;
            b = temp + b;
        }

        return fibonacciSum(fib, A);
    }
}
