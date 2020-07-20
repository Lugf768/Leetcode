package com.lgf.array;

public class missingNumber {

    public static void main(String[] args) {
        int[] a ={0,1,2,3,5,6,7,8,9,10};
        int i = missingNumber(a);
        System.out.println(i);
    }
    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int m = (left + right) / 2;
            if(nums[m] == m){
                left = m+1;
            }else{
                right = m-1;
            }
        }
        return left;
    }
}
