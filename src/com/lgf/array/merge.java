package com.lgf.array;

import java.util.Arrays;

public class merge {

    public static void main(String[] args) {
        int[] a ={1,2,3,0,0,0};
        int[] b ={2,5,6};
        String s = merge1(a, 3, b, 3);
        System.out.println(s);
    }

    //使用三指针
    //时间复杂度 : O(n + m)O(n+m)。
    //空间复杂度 : O(1)O(1)。
    public static String merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1, p3 = m+n-1;
        while(p2 >= 0){

            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            }else{
                nums1[p3--] = nums2[p2--];
            }
        }
        return Arrays.toString(nums1);
    }

    //合并后排序
    //时间复杂度 : O((n + m)\log(n + m))O((n+m)log(n+m))。
    //空间复杂度 : O(1)O(1)。
    public static String merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while(nums1[i] !=0){
            i++;
        }
        for(int j =0 ; j < nums2.length; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        return Arrays.toString(nums1);
    }
}
