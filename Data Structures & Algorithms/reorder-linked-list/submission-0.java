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
    public void reorderList(ListNode head) {

        if (head == null && head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Split and Reverse the second half
        ListNode secondHalfHead = slow.next;
        slow.next = null; // Cut the list into two halves

        ListNode prev = null;
        ListNode curr = secondHalfHead;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        ListNode h1 = head;
        ListNode h2 = prev;

        while(h2 != null){
            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;

            h1.next = h2;
            
            h2.next = temp1;

            h1 = temp1;
            h2 = temp2;
        }


        
    }
    public static ListNode reverseOrder(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
