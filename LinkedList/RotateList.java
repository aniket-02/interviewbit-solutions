public class Solution {
    public ListNode rotateRight(ListNode A, int B) {
        int count = 0;
        ListNode head = A;
        ListNode old_head = A;
        ListNode prev = null;
        ListNode current = A;

        while (head != null) {
            count++;
            head = head.next;
        }

        int rotate = B % count;

        if (rotate == 0) {
            return current;
        }

        int nthFromStart = count - rotate;

        while (nthFromStart > 0) {
            nthFromStart--;
            prev = current;
            current = current.next;
        }

        prev.next = null;

        ListNode new_head = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = old_head;

        return new_head;
    }
}
