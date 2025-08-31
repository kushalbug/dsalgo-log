package day6;
import java.util.*;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head
    }
}

