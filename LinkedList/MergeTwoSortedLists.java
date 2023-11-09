public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        ListNode ptrA = A;
        ListNode ptrB = B;

        while (true) {
            if (ptrA == null) {
                tail.next = ptrB;
                break;
            }
            if (ptrB == null) {
                tail.next = ptrA;
                break;
            }

            if (ptrA.val <= ptrB.val) {
                tail.next = ptrA;
                ptrA = ptrA.next;
            } else {
                tail.next = ptrB;
                ptrB = ptrB.next;
            }

            tail = tail.next;
        }

        return head.next;
    }
}
