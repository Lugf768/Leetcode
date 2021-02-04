package com.lgf.jzoffer.chapterSix;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Q66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++){
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--){
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}