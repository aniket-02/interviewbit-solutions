public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode head = A;

        ListNode head1 = new ListNode(-1);
        ListNode tail1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode tail2 = head2;

        while (head != null) {
            if (head.val < B) {
                tail1.next = new ListNode(head.val);
                tail1 = tail1.next;
            } else {
                tail2.next = new ListNode(head.val);
                tail2 = tail2.next;
            }
            head = head.next;
        }

        tail1.next = head2.next;
        return head1.next;
    }
}
