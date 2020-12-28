package com.lgf.jzoffer.chapterTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Q6 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        int[] ints = reversePrint(l1);
        System.out.println(Arrays.toString(ints));
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //遍历链表节点并创建一个相同长度的数组，从尾部设置数组的值
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null){
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--){
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    //递归法：先走至链表末端，回溯时依次将节点值加入列表 ，这样就可以实现链表值的倒序输出。
    static ArrayList<Integer> tmp = new ArrayList<Integer>();
    public static int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    static void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    //辅助栈法：遍历链表访问每个节点并入栈，出栈存储与数组并返回
    public static int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

}
