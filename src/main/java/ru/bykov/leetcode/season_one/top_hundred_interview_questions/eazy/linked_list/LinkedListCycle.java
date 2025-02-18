package top_hundred_interview_questions.eazy.linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        Set<Integer> indexMap = new HashSet<>();
    }

    /**
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    public boolean hasCycleV2(ListNode head) {
        ListNode low = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == low || fast.next == low) {
                return true;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }

    /**
     * Time complexity: O(n)
     * Memory complexity: O(n)
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> indexMap = new HashSet<>();

        while (head != null) {
            if (!indexMap.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
