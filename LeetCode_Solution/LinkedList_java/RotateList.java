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
      if(head==null || head.next==null || k==0)
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
      int t=n-k-1;
      ListNode Ntail=head;
      for(int i=0;i<t;i++)
      {
        Ntail=Ntail.next;
      }
      ListNode Nhead=Ntail.next;
      Ntail.next=null;
      temp.next=head;
     return Nhead;
    
           
    }
}