package com.lgf.jzoffer.chapterThree;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Q18 {

    //双指针实现
    public ListNode deleteNode1(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = cur.next;
        }
        return head;
    }


    //单指针实现
    public ListNode deleteNode2(ListNode head, int val) {
        if (head== null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val){
            cur = cur.next;
        }
        if (cur.next != null){
            cur.next = cur.next.next;
        }
        //此时，头节点不变，删除的为后面某个节点，题目要求返回头节点即可
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}