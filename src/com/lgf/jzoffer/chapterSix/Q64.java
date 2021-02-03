package com.lgf.jzoffer.chapterSix;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Q64 {

    //逻辑运算符的短路效应：n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
    int res = 0;
    public int sumNums(int n) {
       boolean x = n > 1 && sumNums(n - 1) > 0;
       res += n;
       return res;
    }
}
