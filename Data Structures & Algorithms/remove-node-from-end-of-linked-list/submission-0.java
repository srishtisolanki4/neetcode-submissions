/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t=head;
        ListNode dummy=new ListNode(0,head);
        ListNode temp=dummy;
        while(t!=null && n--!=0){
            t=t.next;
        }
        if(t==null)return head.next;

        while(t!=null){
            temp=temp.next;
            t=t.next;
        }
        temp.next=temp.next.next;
        return dummy.next;
    }
}
