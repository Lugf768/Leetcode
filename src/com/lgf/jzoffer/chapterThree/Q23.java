package com.lgf.jzoffer.chapterThree;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 */
public class Q23 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        //使用双指针，一个快指针 fast 每次移动两个节点，一个慢指针 slow 每次移动一个节点。因为存在环所以必相遇某个点
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        /**
         * 假设快指针fast在圈内绕了N圈，则总路径长度为x+Ny+(N-1)z。z为(N-1)倍是因为快慢指针最后已经在z1节点相遇了，后面就不需要再走了。
         * 而慢指针slow总路径长度为x+y。因为快指针是慢指针的两倍，因此 x+Ny+(N-1)z = 2(x+y)。
         * 我们要找的是环入口节点y1，也可以看成寻找长度x的值，x=(N-2)y+(N-1)z。y+z 就是圆环的总长度，x=(N-2)(y+z)+z。
         * 这个等式左边是从起点x1到环入口节点y1的长度，而右边是在圆环中走过(N-2)圈，再从相遇点z1再走过长度为z的长度。
         * 此时如果让两个指针同时从起点x1和相遇点z1开始，每次只走过一个距离，那么最后他们会在环入口节点相遇。
         */
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
