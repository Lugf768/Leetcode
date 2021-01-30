package com.lgf.jzoffer.chapterSix;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Q53_1 {

    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] <= tar){
                i = m + 1;
            }else{
                j = m - 1;
            }
        }
        return i;
    }
}
