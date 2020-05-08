package com.uioqv.leetcode.addtwonumbers;

/**
 * @author LiuGuoQing
 * @since 2020-04-28
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if(next == null) {
                return "" + val;
            } else {
                return next.toString() + val;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }


    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int v) {
        int l2val = l2 == null? 0 : l2.val;
        int l1val = l1 == null? 0 : l1.val;
        int val = l1val + l2val + v;
        ListNode listNode = new ListNode(val % 10);
        int outherVal = val / 10;
        ListNode l1Next = l1 != null && l1.next != null ? l1.next : null;
        ListNode l2Next = l2 != null && l2.next != null ? l2.next : null;
        if(l1Next != null || l2Next != null || outherVal != 0) {
            listNode.next = addTwoNumbers(l1Next, l2Next, outherVal);
        }
        return listNode;
    }

    public static void main(String[] args) {
//        (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);


        ListNode listNode2 = new AddTwoNumbers().addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2);
    }
}
