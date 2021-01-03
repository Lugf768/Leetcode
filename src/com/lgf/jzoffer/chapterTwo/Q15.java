package com.lgf.jzoffer.chapterTwo;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Q15 {

    /**
     * 初始化数量统计变量res=0 。
     * 循环逐位判断：当n=0 时跳出。
     * res += n & 1：若 n&1=1,则统计数res加一。
     * n >>>= 1：将二进制数字n无符号右移一位 。
     * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
