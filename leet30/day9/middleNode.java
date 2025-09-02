package day9;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
        }

        return slow; // middle node
    }
}
