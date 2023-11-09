/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode A) {
        ListNode head = A;
        ListNode slow_ptr = A;
        ListNode fast_ptr = A;

        boolean isCyclic = false;

        while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;

            if (slow_ptr == fast_ptr) {
                isCyclic = true;
                break;
            }
        }

        if (!isCyclic) {
            return null;
        }

        slow_ptr = head;

        while (slow_ptr != fast_ptr) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }

        return slow_ptr;
	}
}
