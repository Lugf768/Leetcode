package com.lgf.array;

public class removeElement {

    public static void main(String[] args) {
        int[] a ={0,1,2,2,2,0,4,2};
        int i = removeElement(a,2);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            if(nums[i] == val){
                nums[i] = nums[j];
                j--;
            }else{
                i++;
            }
        }
        return i;
    }
}
