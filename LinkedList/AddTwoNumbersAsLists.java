public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head1 = A;
        ListNode head2 = B;
        
        ListNode result = new ListNode(0);
        ListNode tail = result;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int sum = (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0) + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return result.next;
    }
}
