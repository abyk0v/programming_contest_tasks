package top_hundred_interview_questions.eazy.linked_list;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode head, int n) {
        if (n == 1) {
            // обработка списка из одного елемента
            if (head.next == null) {
                return null;
            }

            // 2-а елемента и больше
            ListNode left = head;
            while(left.next.next != null) {
                left = left.next;
            }
            left.next = null;
            return head;
        }

        ListNode left = head;
        ListNode right = head;

        for(int i=1; i < n; i++) {
            right = right.next;
        }

        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        // удаляем текущий елемент елемент
        left.val = left.next.val;
        left.next = left.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
