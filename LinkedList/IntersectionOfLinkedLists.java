public class Solution {
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode headA = A;
        ListNode headB = B;
        int n = 0;
        int m = 0;
        
        while (headA != null) {
            headA = headA.next;
            n++;
        }
        
        while (headB != null) {
            headB = headB.next;
            m++;
        }

        headA = A;
        headB = B;
        
        if (n > m) {
            int p = n - m;
            while (p > 0) {
                p--;
                headA = headA.next;
            }
        } else if (m > n) {
            int p = m - n;
            while (p > 0) {
                p--;
                headB = headB.next;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
	}
}
