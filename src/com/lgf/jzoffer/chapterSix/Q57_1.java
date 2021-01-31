package com.lgf.jzoffer.chapterSix;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Q57_1 {

    //利用 HashMap可以通过遍历数组找到数字组合，时间和空间复杂度均为O(N)；
    //注意本题的nums是排序数组 ，因此可使用双指针法将空间复杂度降低至O(1)。
    public int[] twoSum(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) {
                i++;
            }
            else if(s > target) {
                j--;
            }
            else {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[0];
    }
}
