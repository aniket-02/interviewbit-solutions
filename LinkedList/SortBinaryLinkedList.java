public class Solution {
    public ListNode solve(ListNode A) {
        ListNode head = A;
        int count = 0;
        while (head != null) {
            if (head.val == 0) {
                count++;
            }
            head = head.next;
        }
        
        head = A;
        while (count > 0) {
            count--;
            head.val = 0;
            head = head.next;
        }
        
        while (head != null) {
            head.val = 1;
            head = head.next;
        }
        
        return A;
    }
}
