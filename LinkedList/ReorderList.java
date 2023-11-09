/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }
    
    public ListNode reorderList(ListNode A) {
        ListNode slowPtr = A;
        ListNode fastPtr = A;
        ListNode head1 = A;
        ListNode prev = null;

        while (slowPtr != null && fastPtr != null) {
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr != null) {
                fastPtr = fastPtr.next;
            }
        }

        prev.next = null;
        ListNode head2 = reverse(slowPtr);

        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head2.next = temp1;
            head1.next = head2;

            head1 = temp1;
            head2 = temp2;
        }

        return A;
    }
}
