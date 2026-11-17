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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) return head;

        ListNode temp = head;
        ListNode before = null;
        int curr = 1;

        // Move temp to the left position
        while (curr < left) {
            before = temp;
            temp = temp.next;
            curr++;
        }

        // Save the starting node of the part to reverse
        ListNode start = temp;
        ListNode prev = null;

        // Reverse nodes from left to right
        int pass = right - left + 1;

        while (pass > 0) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            pass--;
        }
    
        // Connect the reversed part with the remaining list
        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }

        start.next = temp;

        return head;
    }
}
