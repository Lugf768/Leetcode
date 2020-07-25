package com.lgf.array;

public class searchInsert {

    public static void main(String[] args) {
        int[] a ={1,2,4,5};
        int i = searchInsert1(a,6);
        System.out.println(i);
    }

    public static int searchInsert1(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        if (nums[nums.length-1] < target){
            return nums.length;
        }
        int i = 0;
        while (nums[i] <= target){
            if (nums[i] == target){
                return i;
            }
            i++;
        }
        return i;
    }

}
