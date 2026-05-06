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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list1;
        int i=0;
        while(i<a-1)
        {
            temp1=temp1.next;
            i++;
        }
        int j=0;
         while(j<b+1)
         {
            temp2=temp2.next;
            j++;
         }
        temp1.next=list2;
        ListNode second=list2;
        while(second.next!=null)
        {
            second=second.next;
        }
        second.next=temp2;
        return list1;
       
    }
}