package com.lgf.jzoffer.chapterFive;

import java.util.Arrays;

/**
 *输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Q45 {

    public String minNumber(int[] nums) {

        if(nums == null || nums.length == 0){
            return "";
        }

        int n = nums.length;
        String [] numStr = new String [n];;

        for(int i = 0; i < n; i++){
            numStr[i] = nums[i] + "";
        }

        Arrays.sort(numStr, (s1, s2) -> (s1+s2).compareTo(s2 + s1));
        String ret = "";

        for(String str:numStr){
            ret += str;
        }
        return ret;
    }
}
