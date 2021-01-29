package com.lgf.jzoffer.chapterFive;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Q51 {

    //暴力解法（超时）
    public int reversePairs1(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    a++;
                }
            }
        }
        return a;
    }

    //归并排序
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for(int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[len];
        return reversePairs(copy, 0, len - 1, tmp); //方法重载机制
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmp){
        if(left == right){
            return 0; //递归终结者
        }
        int mid = left + (right - left) / 2;//此处采用此方式是因为(right + left) / 2中的right + left可能产生越界
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);
        if(nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs; // 此时，左边子数组的最大数小于右边子数组的最小数，直接合并即可，不会产生逆序对
        }
        int crossPairs = mergerAndCount(nums, left, mid, right, tmp); //crossPairs是将两个有序子数组归并为一个有序数组产生的逆序对
        return crossPairs + rightPairs + leftPairs;
    }

    private int mergerAndCount(int[] nums, int left, int mid, int right, int[] tmp){
        //全程采用一个数组tmp的原因有二：不必一直创建新的数组，节约资源；每次处理的都是子数组，如果创建新的数组会导致索引的处理很麻烦，容易出错
        for(int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left;   //左边的有序数组的左边界
        int j = mid + 1;//右边的有序数组的左边界
        int count = 0;
        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                nums[k] = tmp[j]; //此时左边的子数组长度为0
                j++;
            }else if(j == right + 1){
                nums[k] = tmp[i]; //此时右边的子数组长度为0
                i++;
            }else if(tmp[i] <= tmp[j]){ //这儿必须得是“<=”，如是“<”，则归并排序是不稳定的
                nums[k] = tmp[i]; //左边子数组的值较小，进入有序数组
                i++;
            }else{
                nums[k] = tmp[j]; //此时，右边子数组的值较小，进入有序数组
                j++;
                count += (mid - i + 1);//左边子数组剩余的个数即为逆序对个数
            }
        }
        return count;
    }
}
