package com.lgf.jzoffer.chapterThree;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class Q16 {
    public static void main(String[] args) {
        double x = 1;
        int n = Integer.MIN_VALUE;
        double v = myPow(x, n);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        //如果n等于0，直接返回1
        if(n == 0){
            return 1;
        }
        //如果n小于0，把它改为正数，把1/x提取出来是因为n=[−2147483648,2147483647]最小值时，会报错
        if (n < 0){
            return 1/x * myPow(1/x, -n-1);
        }
        //根据n是奇数还是偶数来做不同的处理
        return (n % 2 ==0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
