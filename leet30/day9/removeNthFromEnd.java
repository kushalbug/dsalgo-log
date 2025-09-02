package day9;


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node before head to handle edge cases (like removing the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead so that slow points to the node before target
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return dummy.next; // return new head
    }
}
