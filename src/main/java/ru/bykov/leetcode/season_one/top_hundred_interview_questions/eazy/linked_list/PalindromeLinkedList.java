package top_hundred_interview_questions.eazy.linked_list;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
        ListNode node5 = new ListNode(1);
        node4.next = node5;

        printList(head);
        System.out.println(isPalindromeV2(head));

        printList(head);
    }

    /**
     * Time complexity: o(n)
     * Space complexity: O(1)
     *
     * 1. подсчитать кол-во елементов в списке
     * 2. развернуть вторую половину списка (k/2)
     * 3. сравнить с двух концов k/2 чисел
     * 4. развернуть вторую половину списка обратно
     */
    public static boolean isPalindromeV2(ListNode head) {
        // 1
        int count = 0;
        ListNode pointer = head;
        while (pointer != null) {
            count += 1;
            pointer = pointer.next;
        }

        // 2
        pointer = head;
        for (int i = 0; i < count/2; i++) {
            pointer = pointer.next;
        }
        ListNode last = pointer;
        pointer = pointer.next;
        while (pointer != null) {
            ListNode next = pointer.next;
            pointer.next = last;
            last = pointer;
            pointer = next;
        }

        // 3
        boolean result = true;
        pointer = last;
        for (int i = 0; i < count/2; i++) {
            if (head.val != pointer.val) {
                result = false;
                break;
            }
            head = head.next;
            pointer = pointer.next;
        }

        // 4
        ListNode previosly = null;
        pointer = last;
        while (pointer.next != null) {
            if (pointer.next.next == pointer) {
                pointer.next = previosly;
                break;
            }
            ListNode tmp = pointer.next;
            pointer.next = previosly;
            previosly = pointer;
            pointer = tmp;
        }

        return result;
    }

    /**
     * Time complexity: O(2n) => o(n)
     * Space complexity: O(1)
     */
    public static boolean solve(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode pointer = head;
        while (pointer != null) {
            stack.addLast(pointer.val);
            pointer = pointer.next;
        }

        pointer = head;
        while (pointer != null) {
            if (pointer.val != stack.pollLast()) {
                return false;
            }
            pointer = pointer.next;
        }
        return true;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public boolean isPalindrome_XM(ListNode head) {
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        while (head != last) {
            if (head.val != last.val) {
                return false;
            }

            ListNode newLast = head.next;
            while (newLast.next != last) {
                last = newLast;
            }
            head = head.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static void printList(ListNode node) {
        ListNode tmp = node;
        while(tmp != null) {
            System.out.print(tmp.val + ", ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
