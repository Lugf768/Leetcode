package com.lgf.jzoffer.chapterTwo;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Q9 {

    class CQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }
        //时间复杂度是 O(n)
        public void appendTail(int value) {
            //要先把二的元素重新入1.为保证之前的顺序
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }
        //时间复杂度是 O(n)
        public int deleteHead() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()){
                return -1;
            }
            return stack2.pop();
        }
    }


    class CQueue1 {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue1() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            //入栈的时候可以直接入栈，不需要判断stack2，此时的时间复杂度为O(1)
            stack1.push(value);
        }

        //时间复杂度是 O(n)
        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }

}
