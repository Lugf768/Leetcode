package com.lgf.jzoffer.chapterFive;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Q48 {

    //hashMap的方式
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();

        int res = 0, left = 0;
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //判断c是否出现过
            //"abcabcbb"
            if(hash.containsKey(c)){
                left = Math.max(left, hash.get(c)+1);
            }
            hash.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
