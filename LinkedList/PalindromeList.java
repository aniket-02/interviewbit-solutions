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
    
    public int lPalin(ListNode A) {
        ListNode slow_ptr = A;
        ListNode fast_ptr = A;
    
        while (fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            if (fast_ptr.next != null) {
                fast_ptr = fast_ptr.next;
            }
        }
    
        ListNode B = reverse(slow_ptr);
    
        ListNode ptr_a = A;
        ListNode ptr_b = B;
    
        while (ptr_b != null) {
            if (ptr_a.val != ptr_b.val) {
                return 0;
            }
            ptr_a = ptr_a.next;
            ptr_b = ptr_b.next;
        }
    
        return 1;
    }
}
    