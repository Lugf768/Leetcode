package com.lgf.jzoffer.chapterThree;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Q25 {

    //伪头节点，遍历
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    //递归实现
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        if(l1.val<l2.val)
        {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
