package com.lgf.jzoffer.chapterSix;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Q58_1 {


    /**
     * 倒序遍历字符串s，记录单词左右索引边界 i,j ；
     * 每确定一个单词的边界，则将其添加至单词列表res ；
     */
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' '){   //搜索首个空格
                i--;
            }
            res.append(s.substring(i + 1, j + 1) + ' ');    //添加单词
            while (i >= 0 && s.charAt(i) == ' '){   //跳过单词间空格
                i--;
            }
            j = i;  //j 指向下个单词的尾字符
        }
        return res.toString().trim();   //转化为字符串并返回
    }
}
