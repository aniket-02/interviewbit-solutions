public class Solution {
    public ListNode solveUtil(ListNode A, int B) {
        ListNode current = A;
        ListNode prev = null;

        int count = 0;

        while (current != null && count < B) {
            count++;
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        if (A != null)
            A.next = current;
        
        count = 0;
        
        while (current != null && count < B-1) {
            current = current.next;
            count++;
        }
        
        if (current != null)
            current.next = solveUtil(current.next, B);
        return prev;
    }
    
    public ListNode solve(ListNode A, int B) {
        return solveUtil(A, B);
    }
}
