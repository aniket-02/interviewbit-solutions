public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        if (A == null) {
            return null;
        }

        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        while (current != null && count < B) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            A.next = reverseList(next, B);
        }

        return prev;
    }
}
