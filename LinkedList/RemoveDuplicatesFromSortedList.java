public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        ListNode head = A;
        ListNode prev = new ListNode(Integer.MIN_VALUE);
        prev.next = current;

        while (current != null) {
            if (current.val == prev.val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}
