package com.lgf.jzoffer.chapterSix;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
//位运算 + 有限状态自动机
public class Q56_2 {

    //哈希表统计
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, -1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
}
