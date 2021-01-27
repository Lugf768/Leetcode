package com.lgf.jzoffer.chapterFive;

import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。s只包含小写字母。
 */
public class Q50 {

    public char firstUniqChar(String s) {
        //哈希表的方法
        HashMap<Character, Boolean> hash = new HashMap<>();

        char[] chars = s.toCharArray();
        //如果存在，即设置为false
        for (char a : chars) {
            hash.put(a, !hash.containsKey(a));
        }
        for (char c : chars) {
            if (hash.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
