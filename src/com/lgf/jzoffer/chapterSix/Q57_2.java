package com.lgf.jzoffer.chapterSix;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Q57_2 {

    //滑动窗口在这道题中，我们关注的是滑动窗口中所有数的和。
    // 当滑动窗口的右边界向右移动时，也就是 j = j + 1，窗口中多了一个数字 j，窗口的和也就要加上 j。
    // 当滑动窗口的左边界向右移动时，也就是 i = i + 1，窗口中少了一个数字 i，窗口的和也就要减去 i。
    // 滑动窗口只有右边界向右移动（扩大窗口）和左边界向右移动（缩小窗口） 两个操作
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2){
            if (sum < target){
                sum += j;   //右边界向右移动
                j++;
            }else if (sum > target){
                sum -= i;   //左边界向右移动
                i++;
            }else {
                //记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++){
                    arr[k - i] = k;
                }
                res.add(arr);
                //左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
