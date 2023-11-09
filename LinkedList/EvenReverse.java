/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode even = null;
        ListNode odd = A;
        ListNode head = A;

        if (odd == null || odd.next == null || odd.next.next == null) {
            return odd;
        }

        while (odd != null && odd.next != null) {
            ListNode temp = odd.next;
            odd.next = temp.next;
            temp.next = even;
            even = temp;
            odd = odd.next;
        }

        odd = head;

        while (even != null) {
            ListNode temp = even.next;
            even.next = odd.next;
            odd.next = even;
            even = temp;
            odd = odd.next.next;
        }

        return A;
    }
}
