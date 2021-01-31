package com.lgf.jzoffer.chapterSix;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Q58_2 {

    //方法一：字符串切片。获取字符串s[n:]切片和 s[:n]切片，使用"+"运算符拼接并返回即可。时间空间复杂度O(n)
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    //方法二：列表遍历拼接。新建一个、StringBuilder，记为res,先向res添加“第n+1位至末位的字符”；再向res添加 “首位至第n位的字符”
    //将res转化为字符串并返回。时间空间复杂度O(n)
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    //利用求余运算，可以简化代码。
    public String reverseLeftWords3(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    //方法三：字符串遍历拼接，若规定Python不能使用join()函数，或规定Java只能用String，则使用此方法。
    public String reverseLeftWords4(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

    //同理，利用求余运算，可以简化代码。
    public String reverseLeftWords5(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }

}
