package ru.bykov.leetcode.season_one.medium;

public class task2_Add_Two_Numbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode answer = addTwoNumbers(numberToList(9999999), numberToList(9999));
        System.out.println("asd");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode newNode = null;
        int remnant = 0;
        while(l1 != null || l2 != null || remnant != 0) {

            if (head == null) {
                newNode = new ListNode();
                head = newNode;
                int number_1 = l1 != null ? l1.val : 0;
                int number_2 = l2 != null ? l2.val : 0;
                int number = number_1 + number_2 + remnant;
                newNode.val = number % 10;
                remnant = number / 10;
            } else {
                newNode.next = new ListNode();
                newNode = newNode.next;
                int number_1 = l1 != null ? l1.val : 0;
                int number_2 = l2 != null ? l2.val : 0;
                int number = number_1 + number_2 + remnant;
                newNode.val = number % 10;
                remnant = number / 10;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head;
    }

    // For test
    private static ListNode numberToList(long number) {
        ListNode head = null;
        String strResult = Long.toString(number);

        ListNode newList = null;
        for (int i = strResult.length() - 1; i >= 0; i--) {

            if (newList == null) {
                newList = new ListNode();
                head = newList;
                newList.val = Character.getNumericValue(strResult.charAt(i));
            } else {
                newList.next = new ListNode();
                newList = newList.next;
                newList.val = Character.getNumericValue(strResult.charAt(i));
            }
        }
        return head;
    }
}
