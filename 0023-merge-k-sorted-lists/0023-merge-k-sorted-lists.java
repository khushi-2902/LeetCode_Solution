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
    public ListNode mergeKLists(ListNode[] lists) {
          ListNode head=new ListNode(-1);
          ListNode dummy=head;
         
        if(lists.length==0 || lists==null)
        {
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
         for(int i=0;i<lists.length;i++)
         {
            ListNode currList=lists[i];
             while(currList!=null){
               list.add(currList.val);
                currList=currList.next;
            }
         }

        Collections.sort(list);
         for(int i=0;i<list.size();i++)
         {
          
           
                dummy.next=new ListNode(list.get(i));
                dummy=dummy.next;
          
             
            

         }
         return head.next;
        
    }
}