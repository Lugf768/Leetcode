package com.lgf.jzoffer.chapterSix;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */

//https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-dong-tai-gui-hua-by-zhi-xiong/
//1.构造dp数组：tmp[]为n个骰子的点数概率数组，pre[]为n-1个骰子的点数概率数组，一个骰子的点数概率数组显然是6个六分之一,不需要另设数组。
//2.初始化dp数组：pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
//3.构造状态转移方程:tmp[x+y]+=pre[x]*num[y];
public class Q60 {

    //使得n-1点数概率数组和1点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
    //运算完成后就得到了最终的n点数概率数组。
    //比如n为4,1和1=>2,2和1=>3,3和1=>4  最终得出4中所有可能出现的和的概率
    public double[] dicesProbability(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            //为n的数组概率
            double tmp[] = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++){
                for (int x = 0; x < 6; x++){
                    //为(n-1)和1的数组概率计算
                    tmp[j + x] += pre[j] / 6;
                }
            }
            //为n-1的数组概率
            pre = tmp;
        }
        return pre;
    }
}
