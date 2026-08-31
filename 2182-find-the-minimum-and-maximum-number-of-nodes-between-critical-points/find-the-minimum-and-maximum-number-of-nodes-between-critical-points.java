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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first=-1;
        int prevs=-1;
        int max=0;
        int pos=1;
        int min=Integer.MAX_VALUE;
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr!=null && curr.next!=null){
            ListNode next=curr.next;
            if((curr.val<prev.val && curr.val<next.val)||(curr.val>prev.val && curr.val>next.val)){
                if(first==-1){
                    first=pos;
                    
                }
                else{
                    int distance=pos-prevs;
                    min=Math.min(min,distance);
                }
                prevs=pos;

            }
            prev=curr;
            curr=curr.next;
            pos++;
        }
        if(first==-1|| first==prevs){
            return new int[]{
                -1,-1
            };
            
        }
            max=prevs-first;
            return new int[]{min,max};
    }
}