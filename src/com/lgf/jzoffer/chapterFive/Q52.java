package com.lgf.jzoffer.chapterFive;

/**
 * 输入两个链表，找出它们的第一个公共节点
 */
public class Q52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode PA = headA;
        ListNode PB = headB;
        while (PA != PB) {
            PA = PA == null ? headB : PA.next;
            PB = PB == null ? headA : PB.next;
        }
        return PA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
