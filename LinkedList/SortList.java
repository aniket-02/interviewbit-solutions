public class Solution {
    public ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = new ListNode(a.val);
                a = a.next;
            } else {
                tail.next = new ListNode(b.val);
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null) {
            tail.next = b;
        }
        if (b == null) {
            tail.next = a;
        }

        return head.next;
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        int listLength = 0;
        ListNode current = A;

        while (current != null) {
            listLength++;
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        for (int size = 1; size < listLength; size *= 2) {
            ListNode prev = dummy;
            current = dummy.next;

            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);

                prev.next = sortedMerge(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    public ListNode split(ListNode head, int size) {
        if (head == null) {
            return null;
        }

        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }

        ListNode second = head.next;
        head.next = null;
        return second;
    }
}
