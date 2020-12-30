package com.lgf.jzoffer.chapterTwo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Q10_2 {

    public static void main(String[] args) {
        int i = numWays1(2);
        System.out.println(i);
    }

    /**
     * 设跳上n级台阶有f(n)种跳法。在所有跳法中，青蛙的最后一步只有两种情况：跳上1级或2级台阶。
     *     当为1级台阶：剩n-1个台阶，此情况共有f(n-1)种跳法；
     *     当为2级台阶：剩n-2个台阶，此情况共有f(n-2)种跳法；
     *     f(n)为以上两种情况之和，即f(n)=f(n-1)+f(n-2)
     * 本题的最优解即利用动态规划
     * 状态定义：设dp为一维数组，其中 dp[i]的值代表 斐波那契数列第 $i$ 个数字 。
     * 转移方程：dp[i+1]=dp[i]+dp[i−1],即对应数列定义f(n+1)=f(n)+f(n−1) ；
     * 初始状态：dp[0]=1,dp[1]=1 ，即初始化前两个数字；
     * 返回值：dp[n] ，即斐波那契数列的第n个数字
     */

    //动态规划，时间和空间复杂度均为O(n)
    public static int numWays1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }
        return dp[n];
    }

    //O(1)的空间复杂度的动态规划
    public static int numWays2(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
