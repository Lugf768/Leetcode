package com.lgf.array;

import java.util.HashMap;
import java.util.Map;

public class countCharacters {


    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        int i = countCharacters3(words, chars);
        System.out.println(i);
    }

    /**
     * 第一种
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters1(String[] words, String chars) {
        int[] chars_count = count(chars);
        int res = 0;
        for(String word : words){
            int[] word_count = count(word);
            if(contains(chars_count, word_count)){
                res += word.length();
            }
        }
        return res;
    }

    static boolean contains(int[] chars_count, int[] word_count){
        for(int i = 0; i < 26; i++){
            if(chars_count[i] < word_count[i]){
                return false;
            }
        }
        return true;

    }

    static int[] count(String chars){
        int[] counter = new int[26];
        for(int i = 0; i < chars.length(); i++){
            char c = chars.charAt(i);
            counter[c - 'a']++;
        }
        return counter;
    }

    /**
     * 第二种
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters2(String[] words, String chars) {
        int[] charsOfCase = new int[26];//统计字符表中的字符
        int count = 0;//单词长度之和

        for(char c : chars.toCharArray()){//统计字符表中的字符
            charsOfCase[c-'a']++;
        }
        for(String str : words){
            int[] temp = new int[26];
            boolean flag = true;
            for(char c : str.toCharArray()){//存储统计词汇表中单词的字符
                temp[c-'a']++;
            }
            for(int i = 0; i < charsOfCase.length; i++){//对比两个统计数据
                if(temp[i] > charsOfCase[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) count += str.length();
        }
        return count;
    }

    /**
     * hashMap版本
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters3(String[] words, String chars) {
        /* 如果words为空或者长度为0
           如果chars为空或者长度为0
           直接返回0 */
        if (words == null || words.length == 0 || chars == null || chars.length() == 0)
            return 0;

        int spellOut = 0; // 可以拼出的字母的长度
        // boolean canSpell;    // 标识位，用来标识能否拼出
        Map<Character, Integer> wordCounter;    // words字符计数器
        Map<Character, Integer> charCounter = new HashMap<>();    // chars字符计数器

        /* 记录chars中每个字符出现的次数 */
        for (char c: chars.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }

        /* 记录words中的每个word的每个字符的出现的次数
           并与chars计数器比较 */
        loop:  // 标签，用来处理内部循环与外部循环之间的通信，如不使用，可以在循环使用一个boolean类型的变量来判断是否符合条件
        for (String w: words) {
            /* 如果w为空或者w长度为0或者w的长度>chars的长度，不参与统计 */
            if (w == null || w.length() == 0 || w.length() > chars.length())
                continue;

            wordCounter = new HashMap<>();
            // flag = true;
            for (char c: w.toCharArray()) {
                // 判断该字符是否在chars中出现
                if (!charCounter.containsKey(c)) continue loop; // canSpell = false;
                wordCounter.put(c, wordCounter.getOrDefault(c, 0) + 1);
            }
            /* 判断每个word的字符出现次数是否至少在chars中同样出现
               即word的字符出现次数是否<=chars出现的次数 */
            for (char c: wordCounter.keySet()) {
                if (wordCounter.get(c) > charCounter.getOrDefault(c, 0))
                    continue loop;  // canSpell = false亦可；
            }
            //if (canSpell)
            spellOut += w.length();
        }
        return spellOut;
    }
}
