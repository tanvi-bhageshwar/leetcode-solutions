
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevleft = null;

        int size = 2;

        while (left != null && left.next != null) {

            right = left.next;

            // Save the node after the pair
            ListNode nextleft = right.next;

            // Reverse the pair
            reverse(left, size);

            // Connect previous pair
            if (prevleft != null) {
                prevleft.next = right;
            }

            // Set new head
            if (res == null) {
                res = right;
            }

            // Connect the reversed pair to remaining list
            left.next = nextleft;

            // Move to next pair
            prevleft = left;
            left = nextleft;
        }

        return res;
    }

    public static void reverse(ListNode head, int times) {

        ListNode curr = head;
        ListNode prev = null;

        while (times-- > 0) {

            ListNode nex = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nex;
        }
    }
}
