package com.lgf.jzoffer.chapterTwo;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 */
public class Q11 {

    //排序数组的查找问题首先考虑使用二分法解决，其可将遍历法的线性级别时间复杂度降低至对数级别。
    public int minArray(int[] numbers) {

        int i = 0, j = numbers.length-1;
        while (i < j){
            int m = (i + j)/2;
            //当nums[m]>nums[j]时：m一定在左排序数组中，即旋转点x一定在[m+1,j]闭区间内，因此执行i=m+1；
            if (numbers[m] > numbers[j]){
                i = m + 1;
                //当nums[m]<nums[j]时：m一定在右排序数组中，即旋转点x一定在[i,m]闭区间内，因此执行j=m；
            }else if (numbers[m] < numbers[j]){
                j = m;
                //当nums[m]=nums[j]时：无法判断m在哪个排序数组中，解决方案：执行j=j−1缩小判断范围。
            }else {
                j--;
            }
        }
        return numbers[i];
    }
}
