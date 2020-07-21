package com.lgf.array;

public class removeDuplicates {

    public static void main(String[] args) {
        int[] a ={0,1,1,2,2,2,3,5};
        int i = removeDuplicates(a);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
