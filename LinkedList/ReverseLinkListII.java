public class Solution {
    private ListNode[] reverse(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode tail = A;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return new ListNode[]{prev, tail};
    }
    
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode head = A;
        ListNode tail = A;
        ListNode prev1 = new ListNode(-1);
        ListNode newHead = prev1;
        prev1.next = head;
        ListNode prev2 = null;

        while (B > 1) {
            B--;
            prev1 = head;
            head = head.next;
        }

        while (C > 0) {
            C--;
            prev2 = tail;
            tail = tail.next;
        }

        prev1.next = null;
        prev2.next = null;

        ListNode[] reversed = reverse(head);
        head = reversed[0];
        ListNode last = reversed[1];

        prev1.next = head;
        last.next = tail;

        return newHead.next;
    }
}
