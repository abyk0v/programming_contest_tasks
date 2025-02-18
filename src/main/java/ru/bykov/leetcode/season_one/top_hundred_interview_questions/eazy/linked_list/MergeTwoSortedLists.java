package top_hundred_interview_questions.eazy.linked_list;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    /**
     * Time complexity: O(n+m)
     * Memory complexity: O(1)
     */
    public static ListNode solve(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead;
        if (list1.val < list2.val) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }

        ListNode current = newHead;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                break;
            }
            if (list2 == null) {
                current.next = list1;
                break;
            }

            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
