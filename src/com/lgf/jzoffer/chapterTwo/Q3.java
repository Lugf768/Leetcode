package com.lgf.jzoffer.chapterTwo;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目 3：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 以下代码考虑到了无效输入测试用例。先判断数组是否为空或者数组中是否包含0-n-1之外的数字
 */
public class Q3 {

    public static void main(String[] args) {
        int[] nums ={2,3,5,4,3,2,6,7};
        int i = repeat4(nums);
        System.out.println(i);
    }


    //方法一：如果数组不为空，则排序后两两比较，若有相等的值返回，否则返回-1
    public static int repeat1(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        if (nums[nums.length-1] > nums.length-1){
            return -1;
        }
        for (int j = 0; j < nums.length-1; j++){
            if (nums[j] == nums[j+1]){
                return nums[j];
            }
        }
        return -1;
    }

    //方法二：使用set集合，将数组元素一个个加入集合中，若有重复的则直接返回
    public static int repeat2(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] < 0|| nums[i] > nums.length-1){
                return -1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    //方法三：如果没有重复数字，排序后，数字i应该在下标为i的位置，
    // 扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
    // 在交换过程中，如果有重复的数字发生，那么终止返回
    public static int repeat3(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] < 0|| nums[i] > nums.length-1){
                return -1;
            }
        }
        int temp;
        for (int j = 0; j < nums.length; j++){
            while (nums[j] != j){
                if (nums[nums[j]] != nums[j]){
                    temp=nums[j];
                    nums[j]=nums[temp];
                    nums[temp]=temp;
                }else {
                    return nums[j];
                }
            }
        }
        return -1;
    }

    // 题目二：在一个长度为n+1的数组里的数字都在1-n的范围内，找出任意一个重复的数字，
    // 不修改数组找出重复的数字时间复杂度：O(N)，二分法的时间复杂度为 O(logN)，
    // 在二分法的内部，执行了一次 for 循环，时间复杂度为O(N)，故时间复杂度为O(NlogN)。
    // 空间复杂度O(1)，使用了一个 cnt 变量，因此空间复杂度为O(1)。
    public static int repeat4(int[] nums){

        int start=1;
        int end=nums.length-1;
        while(start < end){
            int middle=(start+end) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] <= middle){
                    count++;
                }
            }
            if (count > middle){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return start;
    }
}
