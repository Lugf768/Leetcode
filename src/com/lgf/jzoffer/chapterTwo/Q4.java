package com.lgf.jzoffer.chapterTwo;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Q4 {

    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] n = {};
        boolean a = findNumberIn2DArray(m, 191);
        System.out.println(a);
    }

    /**
     * 解题思路：要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
     * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
     * 当前元素的查找区间为左下角的所有元素。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){ //考虑数组为空的情况下
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0, c = cols - 1;//右上到坐下缩小范围
        while (r <= rows - 1 && c >= 0){
            if (target == matrix[r][c]){
                return true;
            }else if (target > matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }
}
