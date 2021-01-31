package com.lgf.jzoffer.chapterSix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Q59_1 {


    //单向队列：本题难点： 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从O(k)降低至 O(1)。
    public int[] maxSlidingWindow1(int[] nums, int k) {

        if(nums.length == 0 || k == 0){
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        res[0] = deque.peekFirst();

        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    //暴力法基础上优化得到
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0){
            return nums;//0.预处理
        }

        int[] res = new int[nums.length - k + 1];
        //找出滑动窗口一开始的max值，并放入res
        int max = nums[0];
        for(int j = 0; j < k; j++){
            if(nums[j] > max)max = nums[j];
        }
        res[0] = max;
        //向后滑动
        for(int i = 1; i <= nums.length - k; i++){
            if(nums[i - 1] == max){//如果窗口丢掉的值是滑动前的max，就重新在窗口内找max
                max = nums[i];
                for(int j = i + 1; j < i + k; j++){
                    if(nums[j] > max)max = nums[j];
                }
            }else{//如果窗口丢掉的值不是之前的max，就在max和新加入窗口的值之中找大的一个
                max = Math.max(max, nums[i + k - 1]);
            }
            res[i] = max;//放入res
        }
        return res;
    }

}
