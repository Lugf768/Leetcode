package com.lgf.jzoffer.chaptertwo;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Q5 {
    public static void main(String[] args) {
        String s = "i sa";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }

    //直接调用API，简单粗暴
    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
    //遍历s的每一个字符，当c为空格时，向sb后追加"%20",否则追加字符c
    //最后将sb转为字符串并返回
    public static String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
