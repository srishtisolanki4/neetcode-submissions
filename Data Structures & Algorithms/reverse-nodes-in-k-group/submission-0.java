class Solution {
    private ListNode reverse(ListNode head, ListNode stop) {
        ListNode prev = stop;
        ListNode curr = head;
        while (curr != stop) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; 
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) {
                break; 
            }

            ListNode groupStart = groupPrev.next;
            ListNode nextGroupStart = kth.next;

            groupPrev.next = reverse(groupStart, nextGroupStart);
            groupPrev = groupStart;
        }

        return dummy.next;
    }
}