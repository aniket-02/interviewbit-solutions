public class Solution {
    public ListNode insertionSortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode sortedList = null; 
        ListNode current = A; 

        while (current != null) {
            ListNode next = current.next; 

            if (sortedList == null || current.val < sortedList.val) {
                current.next = sortedList;
                sortedList = current;
            } else {
                ListNode search = sortedList;
                while (search.next != null && current.val >= search.next.val) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }

            current = next;
        }

        return sortedList;
    }
}
