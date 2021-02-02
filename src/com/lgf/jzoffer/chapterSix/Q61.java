package com.lgf.jzoffer.chapterSix;

import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A不能视为 14。
 */
public class Q61 {

    //根据题意，此5张牌是顺子的 充分条件 如下：
    //除大小王外，所有牌无重复 ；
    //设此5张牌中最大的牌为 max ，最小的牌为 min（大小王除外），则需满足：max−min<5
    //https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0){
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)){
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }
}
