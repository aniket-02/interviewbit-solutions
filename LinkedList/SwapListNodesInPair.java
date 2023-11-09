public class Solution {
    public ListNode[] reverse(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return new ListNode[] {prev, A};
    }

    public ListNode swapPairs(ListNode A) {
        ListNode head = A;
        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode newHead = null;

        while (head != null) {
            ListNode tail = head;
            int swap = 2;
            while (swap > 1 && tail.next != null) {
                swap--;
                tail = tail.next;
            }
            ListNode temp = tail.next;
            tail.next = null;
            ListNode[] reversed = reverse(head);
            ListNode node = reversed[0];
            ListNode last = reversed[1];
            if (newHead == null) {
                newHead = node;
            }
            last.next = temp;
            prev.next = node;
            head = node;
            prev = head;
            head = head.next;
            if (head != null) {
                prev = head;
                head = head.next;
            }
        }

        return newHead;
    }
}
