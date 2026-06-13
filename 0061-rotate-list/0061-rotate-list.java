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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
        {
            return head;
        }
       ListNode temp=head;
       int n=1;
       while(temp.next!=null)
       {
          temp=temp.next;
          n++;
       }
       k=k%n;
       if(k==0)
       {
        return head;
       }
        int size=n-k;
        int i=1;
        ListNode newTail=head;
        while(i<size)
        {
            newTail=newTail.next;
            i++;
        }
        ListNode newHead=newTail.next;//firstPointer
        temp.next=head;
        newTail.next=null;
        return newHead;
    }
}