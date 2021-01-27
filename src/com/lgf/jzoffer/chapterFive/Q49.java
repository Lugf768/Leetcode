package com.lgf.jzoffer.chapterFive;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class Q49 {

    //动态规划
    public int nthUglyNumber(int n) {
        int[] f = new int[n];//前n个丑数
        int[] pos = new int[3];//对应235三个质因子

        f[0] = 1;//第一个丑数1
        for(int i = 1; i < n; i++){
            int a = f[pos[0]] * 2;
            int b = f[pos[1]] * 3;
            int c = f[pos[2]] * 5;

            int min = Math.min(Math.min(a, b), c);//一定只包含235的质因子

            if(a == min) pos[0]++;
            if(b == min) pos[1]++;
            if(c == min) pos[2]++;

            f[i] = min;
        }
        return f[n - 1];
    }
}
