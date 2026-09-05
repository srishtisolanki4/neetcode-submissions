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
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle=findMiddle(head);

        ListNode prev=null;
        ListNode curr=middle.next;
        middle.next=null;

        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        

        ListNode t1=head;
        ListNode t2=prev;
        

        while(t2!=null){
            ListNode t1Next=t1.next;
            ListNode t2Next=t2.next;

            t1.next=t2;
            t2.next=t1Next;

            t1=t1Next;
            t2=t2Next;
            
        }

        

    
        
    }
}
