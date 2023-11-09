/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode head = A;
        ListNode prev = null;
        ListNode current = A;
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        if (B >= count) {
            return current.next;
        }

        int nthFromStart = count - B;

        while (nthFromStart > 0) {
            nthFromStart--;
            prev = current;
            current = current.next;
        }

        prev.next = current.next;

        return A;
    }
}
