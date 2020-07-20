package com.lgf.array;

public class findLengthOfLCIS {

    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 6, 3};
        int lengthOfLCIS = findLengthOfLCIS(ints);
        System.out.println(lengthOfLCIS);

    }
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1){
            return nums.length;
        }
        int count = 1, maxcount=1;
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp){
                count++;
                temp = nums[i];
            }else{
                count = 1;
                temp = nums[i];
            }
            maxcount = count > maxcount ? count : maxcount;
        }
        return maxcount;
    }

//    public static int findLengthOfLCIS1(int[] nums) {
//        int ans = 0, anchor = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
//            ans = Math.max(ans, i - anchor + 1);
//        }
//        return ans;
//    }
}
