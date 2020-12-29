package com.lgf.jzoffer.chapterTwo;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Q101 {

    //0 ,1, 1, 2, 3, 5, 8
    public int fib1(int n) {
        if (n <= 1){
            return n;
        }
        int l = 0;
        int r = 1;
        int temp = 0;
        for (int count = 2; count <= n; count++){
            temp = l;
            l = r;
            r = temp + r;
        }
        return r % 1000000007;
    }

    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
