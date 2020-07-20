package com.lgf.array;

import java.util.Arrays;

public class heightChecker {

    public static void main(String[] args) {

        int[] a = {1,1,4,2,1,3};
        int i = heightChecker(a);
        System.out.println(i);
    }
    public static int heightChecker(int[] heights) {
        int[] array = Arrays.copyOf(heights, heights.length);
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
