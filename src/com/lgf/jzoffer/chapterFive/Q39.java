package com.lgf.jzoffer.chapterFive;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Q39 {

    //哈希表统计法： 遍历数组nums，用HashMap统计各数字的数量，即可找出众数。此方法时间和空间复杂度均为O(N)。
    //数组排序法： 将数组nums排序，数组中点的元素 一定为众数。
    //摩尔投票法： 核心理念为票数正负抵消。此方法时间和空间复杂度分别为O(N)和O(1)，为本题的最佳解法。

    public static void main(String[] args) {
        int[] nums = {1};
        int i = majorityElement1(nums);
        System.out.println(i);
    }

    //哈希
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i= 0; i < nums.length; i++){
            //如果已经存在key，将值+1
            if(map.containsKey(nums[i])){
                int tmp = map.get(nums[i]);
                map.put(nums[i], ++tmp);
                if (tmp * 2 > nums.length){
                    return nums[i];
                }
            }else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    //摩尔投票
    //https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
    public static int majorityElement2(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0){
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums){
            if(num == x) {
                count++;
            }
        }
        // 当无众数时返回 0
        return count > nums.length / 2 ? x : 0;
    }

}
