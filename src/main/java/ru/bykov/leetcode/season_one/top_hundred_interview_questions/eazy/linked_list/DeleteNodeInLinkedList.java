package top_hundred_interview_questions.eazy.linked_list;

public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        head.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(9);
        node3.next = node4;

        printList(head);
        solveImproved(node3);

        printList(head);
    }

    private static void solveImproved(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static void solve(ListNode node) {
        while(node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
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
