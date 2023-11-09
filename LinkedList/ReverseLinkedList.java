public class Solution {
    public ListNode reverseList(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}
