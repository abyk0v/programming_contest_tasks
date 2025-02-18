package top_hundred_interview_questions.eazy.linked_list;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    private static ListNode solve2(ListNode head) {
        return recursiveSolve(null, head);
    }

    private static ListNode recursiveSolve(ListNode left, ListNode right) {
        if (right == null) {
            return left;
        }

        ListNode next = right.next;
        right.next = left;
        return recursiveSolve(right, next);
    }

    /**
     *  Time complexity: O(n)
     *  Memory complexity: O(1)
     */
    private static ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode left = null;
        ListNode center = head;
        ListNode right = head.next;
        while(center != null) {
            center.next = left;

            left = center;
            center = right;
            if (right != null) {
                right = right.next;
            }
        }
        return left;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
