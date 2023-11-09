public class Solution {
    public int getCount(ListNode A) {
        int count = 0;
        ListNode current = A;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public int solve(ListNode A, int B) {
        int n = getCount(A);
        int reqNode = (n / 2 + 1) - B;

        if (reqNode <= 0) {
            return -1;
        } else {
            ListNode current = A;
            int count = 1;
            while (current != null) {
                if (count == reqNode) {
                    return current.val;
                }
                count++;
                current = current.next;
            }
        }
        return -1;
    }
}
